package com.org.work.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.work.booking.model.Booking;
import com.org.work.booking.respository.BookingsRepository;
import com.org.work.booking.service.BookingsService;

public class BookingServiceImpl implements BookingsService{

	@Autowired
	BookingsRepository theBookingsRepository;

	public Booking bookTheSeat(Booking book) {
		
		// while saving we can provide the coupon codes for various discounts
		// 50% discount on the third ticket
		// Tickets booked for the afternoon show get a 20% discount
		
		return theBookingsRepository.save(book);
	}
	
}