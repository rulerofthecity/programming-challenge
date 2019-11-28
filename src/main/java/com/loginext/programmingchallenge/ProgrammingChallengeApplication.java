package com.loginext.programmingchallenge;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.loginext.programmingchallenge.model.Driver;
import com.loginext.programmingchallenge.model.Location;
import com.loginext.programmingchallenge.repositories.DriverRepository;
import com.loginext.programmingchallenge.util.CommonUtils;

@SpringBootApplication
public class ProgrammingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingChallengeApplication.class, args);
		
	}

	@Autowired
	DriverRepository driverRepository;
	
	@PostConstruct
	private void init() {
		// sevenHills - 19.120515, 72.878255
				Driver d1 = new Driver();
				Location loc1 = new Location();
				loc1.setLatitude(19.120515);
				loc1.setLongitude(72.878255);
				d1.setLocation(loc1);
				d1.setName("Driver 1");
				d1.setStatus(CommonUtils.AVAILABLE);
				
				// Hiranandai Hosp -- 19.123279, 72.917081
				Driver d2 = new Driver();
				Location loc2 = new Location();
				loc2.setLatitude(19.123279);
				loc2.setLongitude(72.917081);
				d2.setLocation(loc2);
				d2.setName("Driver 2");
				d2.setStatus(CommonUtils.AVAILABLE);
				
				// Sarvodya Hosp -- 19.092458, 72.907381
				Driver d3 = new Driver();
				Location loc3 = new Location();
				loc3.setLatitude(19.092458);
				loc3.setLongitude(72.907381);
				d3.setLocation(loc3);
				d3.setName("Driver 3");
				d3.setStatus(CommonUtils.AVAILABLE);
				
				
				Driver d4 = new Driver();
				Location loc4 = new Location();
				loc4.setLatitude(19.220515);
				loc4.setLongitude(72.871115);
				d4.setLocation(loc4);
				d4.setName("Driver 4");
				d4.setStatus(CommonUtils.AVAILABLE);
				
				
				Driver d5 = new Driver();
				Location loc5 = new Location();
				loc5.setLatitude(19.120515);
				loc5.setLongitude(72.878255);
				d5.setLocation(loc5);
				d5.setName("Driver 5");
				d5.setStatus(CommonUtils.AVAILABLE);
				
				driverRepository.save(d1);
				driverRepository.save(d2);
				driverRepository.save(d3);
				driverRepository.save(d4);
				driverRepository.save(d5);
				
				
				// Rajawadi Colony -- 19.081348, 72.901200 -- Booking location
	}
	
}
