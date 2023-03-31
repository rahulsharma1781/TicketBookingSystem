package com.org.work.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.org.work.booking.model.Movie;
import com.org.work.booking.service.MovieService;

@RestController
public class FecthTheaterDetailsForMovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/healthCheck/FecthTheaterDetailsForMovieController")
	public String healthCheck() {
		return "FecthTheaterDetailsForMovieController is up and running";
	}
	
	@GetMapping("/movie/{ID}/theater")
	public ResponseEntity<List<Movie>> getOneTheater(@PathVariable(value="ID") long movieId){
		List<Movie> showList = movieService.findAllById(movieId);
		if(null == showList || showList.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(showList);
	}
		
}