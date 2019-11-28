package com.loginext.programmingchallenge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginext.programmingchallenge.model.Booking;
import com.loginext.programmingchallenge.model.BookingDetails;
import com.loginext.programmingchallenge.model.Driver;
import com.loginext.programmingchallenge.model.Location;
import com.loginext.programmingchallenge.repositories.BookingRepository;
import com.loginext.programmingchallenge.repositories.DriverRepository;
import com.loginext.programmingchallenge.util.CommonUtils;
import com.loginext.programmingchallenge.util.DriverDistanceComparator;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	DriverRepository driverRepository;
	
	public boolean bookCab(Booking booking) {
		
		List<Driver> drivers = driverRepository.findAll();
		List<Driver> shortListedDrivers = new ArrayList<>();
		boolean atLeastOneDriverAvailable = false;
		for(int i = 0; i < drivers.size() ; i++) {
			if(drivers.get(i).getStatus() == CommonUtils.AVAILABLE) {
				atLeastOneDriverAvailable = true;
				
				Location driverLocation = drivers.get(i).getLocation();
				drivers.get(i).setDistance(getDistance(booking.getLocation().getLatitude(), booking.getLocation().getLongitude(), driverLocation.getLatitude(), driverLocation.getLongitude()));
				shortListedDrivers.add(drivers.get(i));
			}
		}
		
		if(atLeastOneDriverAvailable) {
			Collections.sort(shortListedDrivers, new DriverDistanceComparator());
			System.out.println("Final output --> " + shortListedDrivers.get(0));		
			saveBookingDetails(booking, shortListedDrivers.get(0));
		}
		return atLeastOneDriverAvailable;
	}
	
	private Double getDistance(Double latitude1,
							Double longitude1,
							Double latitude2,
							Double longitude2) {
		int radiusOfEarthInKms = 6371;
		final Double degreeToRadius = 0.017453292519943295;
		Double dLat = (latitude2 - latitude1) * degreeToRadius;
		Double dLon = (longitude2 - longitude1) * degreeToRadius;
		
		Double a = (Math.sin(dLat / 2) * Math.sin(dLat / 2)) +
				(Math.cos(latitude1 * degreeToRadius) * Math.cos(latitude2 * degreeToRadius)) *
				(Math.sin(dLon / 2) * Math.sin(dLon / 2));
		
		Double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		Double c = radiusOfEarthInKms * b;
		
		return c;
	}
	
	private void saveBookingDetails(Booking booking, Driver driver) {
		
		driver.setStatus(CommonUtils.NOT_AVAILABLE);
		driverRepository.save(driver);
		booking.setDriver(driver);
		bookingRepository.save(booking);
	}

	public List<BookingDetails> getAllBookingDetails() {
		// TODO Auto-generated method stub
		List<BookingDetails> bookings = bookingRepository.fetchAllBookingDetails();
		return bookings;
	}
	
}
