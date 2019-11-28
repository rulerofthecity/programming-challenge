package com.loginext.programmingchallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;

public class BookingDetails {
	
	private String driverName;
	
	private String customerName;
	
	private char status;

	public BookingDetails(String driverName, String customerName, char status) {
		this.driverName = driverName;
		this.customerName = customerName;
		this.status = status;
	}
	
	public BookingDetails() {}
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingDetails [driverName=" + driverName + ", customerName=" + customerName + ", status=" + status
				+ "]";
	}
	
}
