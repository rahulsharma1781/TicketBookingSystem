package com.org.work.booking.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.work.booking.model.Booking;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Long> {

}
