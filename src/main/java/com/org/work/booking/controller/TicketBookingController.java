package com.org.work.booking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.work.booking.model.Booking;
import com.org.work.booking.service.BookingsService;

@RestController
public class TicketBookingController {
	
	@Autowired
	BookingsService bookingsService;
	
	
	@GetMapping("/healthCheck/TicketBookingController")
	public String healthCheck() {
		return "TicketBookingController is up and running";
	}
	
	@PostMapping("show/{id}/bookings")
	public Booking bookSeatForShow(@PathVariable (value = "id") long id, @Valid @RequestBody Booking bookings){
		return bookingsService.bookTheSeat(bookings);
	}
}
