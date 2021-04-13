package com.trademehere.movies.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.trademehere.movies.dao.model.MovieDao;

public interface MoviesRepository extends JpaRepository<MovieDao,Long> {

	
}
