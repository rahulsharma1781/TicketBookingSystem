package com.org.work.booking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.work.booking.exception.MovieDuplicatedException;
import com.org.work.booking.exception.MovieNotFoundException;
import com.org.work.booking.model.Movie;
import com.org.work.booking.respository.MovieRepository;
import com.org.work.booking.service.MovieService;

import lombok.Data;

@Service
@Data
public class MovieServiceImpl implements MovieService {

    final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) throws MovieDuplicatedException {
        Movie movieFromDB = movieRepository.findById(movie.getId()).orElse(null);
        if (movieFromDB != null)
            throw new MovieDuplicatedException(movie.getId());
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) throws MovieNotFoundException {
        Movie movieFromDB = movieRepository.findById(movie.getId()).orElse(null);
        if (movieFromDB == null)
            throw new MovieNotFoundException(movie.getId());
        movie.setId(movieFromDB.getId());
        return movieRepository.save(movie);
    }

    @Override
    public Long delete(Long id) throws MovieNotFoundException {
        Movie movieFromDB = movieRepository.findById(id).orElse(null);
        if (movieFromDB == null)
            throw new MovieNotFoundException(id);
        movieRepository.delete(movieFromDB);
        return id;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

	@Override
	public List<Movie> findAllById(long movieId) {
		return movieRepository.findAllById(movieId);
	}

}
