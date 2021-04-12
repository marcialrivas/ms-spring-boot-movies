package com.trademehere.movies.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trademehere.movies.dao.model.MovieDao;
import com.trademehere.movies.repository.MoviesRepository;

import co.elastic.apm.api.CaptureSpan;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MoviesRepository movieRepository;
	
	@Override
	@CaptureSpan
	public Page<MovieDao> findAll(Pageable pageable) {
		return movieRepository.findAll(pageable);
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
	@CaptureSpan
	@Cacheable(value = "movies", key = "#objectId")
	public Optional<MovieDao> findByObjectId(String objectId) {
		log.info("not from cache: "+objectId);
		return movieRepository.findById(objectId);
	}

	@Override
	@CaptureSpan
	public MovieDao saveOrUpdateMovie(MovieDao movie) {
		return movieRepository.save(movie);
	}

	@Override
	@CaptureSpan
	public void deleteMovie(String objectId) {
		movieRepository.deleteById(objectId);

	}

}
