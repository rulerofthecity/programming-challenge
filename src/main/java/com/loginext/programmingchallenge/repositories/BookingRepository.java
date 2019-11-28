package com.loginext.programmingchallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loginext.programmingchallenge.model.Booking;
import com.loginext.programmingchallenge.model.BookingDetails;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
//	@Query("select Driver.name, Booking.customerName , Driver.status from Driver left join Booking order by Driver.name ")
//	public List<BookingDetails> fetchAllBookingDetails();
////	
//	@Query("SELECT new com.loginext.programmingchallenge.repositories.BookingDetails(d.name, b.customerName, d.status) FROM Driver d.id LEFT OUTER JOIN Booking b  ")
//	public List<BookingDetails> fetchAllBookingDetails();

//	 select c.customerName, c.customerCity, i.itemName,i.price from Customer c left join c.items i;

	@Query("SELECT new com.loginext.programmingchallenge.model.BookingDetails( d.name, b.customerName, d.status) FROM Booking b RIGHT JOIN b.driver d")
	public List<BookingDetails> fetchAllBookingDetails();
	
}
