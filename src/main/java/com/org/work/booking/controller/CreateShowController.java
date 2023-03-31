package com.org.work.booking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.work.booking.converter.MovieConverter;
import com.org.work.booking.dto.MovieDTO;
import com.org.work.booking.service.MovieService;

@RestController
public class CreateShowController {
	
	@Autowired
	MovieConverter movieConverter;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/healthCheck/CreateShowController")
	public String healthCheck() {
		return "CreateShowController is up and running";
	}
	
	@PostMapping("/saveMovieInfo")
    public ResponseEntity<?> save(@Valid @RequestBody MovieDTO movieDTO) throws Exception {
        if (movieDTO == null)
            return ResponseEntity.badRequest().body("The provided movie info is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieConverter.convertToDTO(movieService.save(movieConverter.convertToDM(movieDTO))));
    }

}
