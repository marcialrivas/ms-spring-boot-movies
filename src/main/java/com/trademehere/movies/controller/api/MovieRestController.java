package com.trademehere.movies.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.trademehere.movies.service.MovieService;

import co.elastic.apm.api.CaptureTransaction;

import com.trademehere.movies.dao.model.MovieDao;
@RestController
@RequestMapping("/movies")
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping(value="/")
	@CaptureTransaction
	public ResponseEntity<List<MovieDao>> getAllMovies() {
		return new ResponseEntity<>(movieService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/bytitle")
	@CaptureTransaction
	public ResponseEntity<MovieDao> findByTitle(@RequestParam String title) {
		return new ResponseEntity<>(movieService.findByTitle(title) ,HttpStatus.OK);
	}
	
}
