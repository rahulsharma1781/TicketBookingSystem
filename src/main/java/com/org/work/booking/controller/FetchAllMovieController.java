package com.org.work.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.work.booking.converter.MovieConverter;
import com.org.work.booking.dto.MovieDTO;
import com.org.work.booking.service.MovieService;

@RestController
public class FetchAllMovieController {
	
	@Autowired
	MovieConverter movieConverter;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/healthCheck/FetchAllMovieController")
	public String healthCheck() {
		return "DeleteShowController is up and running";
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<MovieDTO>> findAll() {
		return ResponseEntity.ok().body(movieConverter.convertToDTOs(movieService.findAll()));
	}
}
