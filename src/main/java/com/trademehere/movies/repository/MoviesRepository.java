package com.trademehere.movies.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.trademehere.movies.dao.model.MovieDao;

import co.elastic.apm.api.CaptureSpan;

public interface MoviesRepository extends MongoRepository<MovieDao,String> {

	@CaptureSpan
	MovieDao findByTitle(String title);
	@CaptureSpan
	MovieDao findByMovieId(String movieId);
}
