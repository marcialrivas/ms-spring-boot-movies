package com.trademehere.movies.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trademehere.movies.dao.model.MovieDao;

public interface MovieService {

	
	Page<MovieDao> findAll(Pageable pageable);
	
	Optional<MovieDao> findByObjectId(String objectId);
	
}
