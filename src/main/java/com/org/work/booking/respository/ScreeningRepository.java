package com.org.work.booking.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.work.booking.model.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {}
