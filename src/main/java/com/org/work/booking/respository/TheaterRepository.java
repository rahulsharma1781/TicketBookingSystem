package com.org.work.booking.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.work.booking.model.Theatre;

public interface TheaterRepository extends JpaRepository<Theatre, Long> {

}
