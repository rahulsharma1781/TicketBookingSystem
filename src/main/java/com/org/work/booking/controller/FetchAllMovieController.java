package com.org.work.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.org.work.booking.converter.MovieConverter;
import com.org.work.booking.dto.MovieDTO;
import com.org.work.booking.service.MovieService;

public class FetchAllMovieController {
	
	@Autowired
	MovieConverter movieConverter;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public String healthCheck() {
		return "DeleteShowController is up and running";
	}

	@GetMapping("/")
	public ResponseEntity<List<MovieDTO>> findAll() {
		return ResponseEntity.ok().body(movieConverter.convertToDTOs(movieService.findAll()));
	}
}
