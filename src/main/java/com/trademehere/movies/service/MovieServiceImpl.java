package com.trademehere.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trademehere.movies.dao.model.MovieDao;
import com.trademehere.movies.repository.MoviesRepository;

import co.elastic.apm.api.CaptureSpan;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MoviesRepository movieRepository;
	
	@Override
	@CaptureSpan
	public List<MovieDao> findAll() {
		return movieRepository.findAll();
	}

	@Override
	@CaptureSpan
	public MovieDao findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}

	@Override
	@CaptureSpan
	public MovieDao findByMovieId(String movieId) {
		return movieRepository.findByMovieId(movieId);
	}

	@Override
	public Optional<MovieDao> findByObjectId(String objectId) {
		return movieRepository.findById(objectId);
	}

	@Override
	public MovieDao saveOrUpdateMovie(MovieDao movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(String objectId) {
		movieRepository.deleteById(objectId);

	}

}
