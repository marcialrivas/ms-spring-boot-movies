package com.trademehere.movies.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.trademehere.movies.dao.model.MovieDao;

@SpringBootTest
class MovieServiceImplTest {

	@Autowired
	private MovieService movieService;
	
	@Test
	void testFindAll() {
		Pageable pageable = PageRequest.of(0, 5);
		Page<MovieDao> movieDaoList = movieService.findAll(pageable);
		assertTrue(!movieDaoList.isEmpty());
	}

	@Test
	void testFindById() {
		assertEquals((long)1,movieService.findById((long) 1).get().getId());
	}

}
