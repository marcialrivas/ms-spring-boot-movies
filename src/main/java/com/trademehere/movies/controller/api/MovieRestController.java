package com.trademehere.movies.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.trademehere.movies.service.MovieService;

import co.elastic.apm.api.CaptureTransaction;
import lombok.extern.slf4j.Slf4j;

import com.trademehere.movies.assembler.MovieAssembler;
import com.trademehere.movies.dao.model.MovieDao;
import com.trademehere.movies.dto.model.MovieDto;
@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieAssembler movieAssembler;
	
	@Autowired
	private PagedResourcesAssembler<MovieDao> pagedResourcesAssembler;

	@CaptureTransaction
	@GetMapping
	public ResponseEntity<PagedModel<MovieDto>> getAllMovies(Pageable pageable) {
		log.info(pageable.toString());
		Page<MovieDao> movieDaoList = movieService.findAll(pageable);
		PagedModel<MovieDto> collModel = pagedResourcesAssembler.toModel(movieDaoList, movieAssembler);
		return new ResponseEntity<>( collModel,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@CaptureTransaction
	public ResponseEntity<MovieDto> findById(@PathVariable("id") String id) {
		log.info(id);
		return	movieService.findByObjectId(id)
					.map(movieAssembler::toModel)
					.map(ResponseEntity::ok)
					.orElse(ResponseEntity.notFound().build());
	}
	
}
