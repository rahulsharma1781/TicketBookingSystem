package com.org.work.booking.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.work.booking.model.Screening;

@Repository
public interface ShowRepository extends JpaRepository<Screening, Long> {
	
	//public List<Screening> findBytheMovie(Movie m);
}
