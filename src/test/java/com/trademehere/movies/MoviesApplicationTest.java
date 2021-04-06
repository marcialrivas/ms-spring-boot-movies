package com.trademehere.movies;

import com.trademehere.movies.controller.api.HelloWorldController;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoviesApplicationTest {

    @Autowired
	HelloWorldController helloWorldController;

	@Test
	void contextLoads() {
        assertThat(helloWorldController).isNotNull();
	}

}