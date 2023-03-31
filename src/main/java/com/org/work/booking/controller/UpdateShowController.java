package com.org.work.booking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.work.booking.converter.MovieConverter;
import com.org.work.booking.dto.MovieDTO;
import com.org.work.booking.service.MovieService;

@RestController
public class UpdateShowController {
	
	@Autowired
	MovieConverter movieConverter;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/healthCheck/UpdateShowController")
	public String healthCheck() {
		return "UpdateShowController is up and running";
	}
	
	 @PutMapping("/updateMovieInfo")
	    public ResponseEntity<?> update(@Valid @RequestBody MovieDTO movieDTO) throws Exception {
	        if (movieDTO == null)
	            return ResponseEntity.badRequest().body("The provided movie is not valid");
	        return ResponseEntity
	                .ok()
	                .body(movieConverter.convertToDTO(movieService.update(movieConverter.convertToDM(movieDTO))));
	    }

}
