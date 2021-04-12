package com.trademehere.movies;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trademehere.movies.controller.api.MovieRestController;


@SpringBootTest
class MoviesApplicationTest {

    @Autowired
	MovieRestController movieRestController;

	@Test
	void contextLoads() {
        assertThat(movieRestController).isNotNull();
	}

}