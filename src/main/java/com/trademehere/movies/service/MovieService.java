package com.trademehere.movies.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trademehere.movies.dao.model.MovieDao;

public interface MovieService {

	
	Page<MovieDao> findAll(Pageable pageable);
	
	MovieDao findByTitle(String title);
	
	MovieDao findByMovieId(String movieId);
	
	Optional<MovieDao> findByObjectId(String objectId);
	
	MovieDao saveOrUpdateMovie(MovieDao movie);
	
	void deleteMovie(String objectId);
}
