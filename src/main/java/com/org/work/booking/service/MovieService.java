package com.org.work.booking.service;

import java.util.List;

import com.org.work.booking.exception.MovieDuplicatedException;
import com.org.work.booking.exception.MovieNotFoundException;
import com.org.work.booking.model.Movie;

public interface MovieService {

	List<Movie> findAllById(long movieId);
    Movie save(Movie movie) throws MovieDuplicatedException;
    Movie update(Movie movie) throws MovieNotFoundException;
    Long delete(Long id) throws MovieNotFoundException;
    List<Movie> findAll();

}
