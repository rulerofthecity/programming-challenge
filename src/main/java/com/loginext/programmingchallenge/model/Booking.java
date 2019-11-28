package com.loginext.programmingchallenge.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking",
	indexes = {@Index(columnList = "id", name = "idx_booking_id_pk")}
		)
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="customer_name")
	private String customerName;

	@Embedded
	private Location location;
	
	@OneToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", customerName=" + customerName + ", location=" + location + "]";
	}
	

}
