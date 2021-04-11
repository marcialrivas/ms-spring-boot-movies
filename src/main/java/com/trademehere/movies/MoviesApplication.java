package com.trademehere.movies;

import org.springframework.boot.SpringApplication;
import co.elastic.apm.attach.ElasticApmAttacher;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		
		ElasticApmAttacher.attach();
		SpringApplication.run(MoviesApplication.class, args);
	}

}
