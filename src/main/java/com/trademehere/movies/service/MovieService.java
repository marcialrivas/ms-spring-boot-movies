package com.trademehere.movies.service;

import java.util.List;
import java.util.Optional;

import com.trademehere.movies.dao.model.MovieDao;

public interface MovieService {

	List<MovieDao> findAll();
	MovieDao findByTitle(String title);
	MovieDao findByMovieId(String movieId);
	Optional<MovieDao> findByObjectId(String objectId);
	MovieDao saveOrUpdateMovie(MovieDao movie);
	void deleteMovie(String objectId);
}
