package com.org.work.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.org.work.booking.converter.MovieConverter;
import com.org.work.booking.service.MovieService;

@RestController
public class DeleteShowController {

	@Autowired
	MovieConverter movieConverter;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/healthCheck/DeleteShowController")
	public String healthCheck() {
		return "DeleteShowController is up and running";
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("The provided movie's id is not valid");
        return ResponseEntity.ok().body("Movie [" + movieService.delete(id) + "] deleted successfully.");
    }

   
	
}
