package com.loginext.programmingchallenge.util;

import java.math.BigDecimal;
import java.util.Comparator;

import com.loginext.programmingchallenge.model.Driver;

public class DriverDistanceComparator implements Comparator<Driver> {

	@Override
	public int compare(Driver driver1, Driver driver2) {
		// TODO Auto-generated method stub
		
		BigDecimal b1 = new BigDecimal(driver1.getDistance());
		BigDecimal b2 = new BigDecimal(driver2.getDistance());
		
		return b1.compareTo(b2);
	}

}
