package com.org.work.booking.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.work.booking.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "select m_id, m_name, m_description from table_movie, table_show as s  where s.the_theater_t_id = ?1", nativeQuery = true)
	public List<Object[]> getMovieByTheateID(long ID);

	public List<Movie> findAllById(long movieId);

}
