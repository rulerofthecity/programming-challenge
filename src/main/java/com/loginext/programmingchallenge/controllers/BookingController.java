package com.loginext.programmingchallenge.controllers;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginext.programmingchallenge.model.Booking;
import com.loginext.programmingchallenge.model.BookingDetails;
import com.loginext.programmingchallenge.model.Location;
import com.loginext.programmingchallenge.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService service;
	
	@PostMapping("/bookCab")
	public boolean findDriver(@RequestBody String bookingDetails) throws JSONException {
		System.out.println("Server is hit with request -- " + bookingDetails);
		JSONObject requestJson =  new JSONObject(bookingDetails);
		Booking booking = new Booking();
		booking.setCustomerName(requestJson.getString("customerName"));
		Location loc = new Location();
		loc.setLatitude(requestJson.getJSONObject("location").getDouble("latitude"));
		loc.setLongitude(requestJson.getJSONObject("location").getDouble("longitude"));
		booking.setLocation(loc);
		
		return service.bookCab(booking);
	}
	
	@GetMapping("/getAllBookingDetails")
	public List<BookingDetails> allBookingDetails() {
		return service.getAllBookingDetails();
	}
	
}
