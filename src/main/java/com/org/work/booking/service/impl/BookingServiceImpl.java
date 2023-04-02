package com.org.work.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.work.booking.model.Booking;
import com.org.work.booking.respository.BookingsRepository;
import com.org.work.booking.service.BookingsService;

import lombok.Data;

@Service
@Data
public class BookingServiceImpl implements BookingsService{

	@Autowired
	BookingsRepository theBookingsRepository;

	public Booking bookTheSeat(Booking book) {
		
		// Push this booking object to the payment service, if success then return the
		// booking object else call the fallback method;
		
		return theBookingsRepository.save(book);
	}
	
}