package com.trademehere.movies;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import co.elastic.apm.attach.ElasticApmAttacher;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {

		ElasticApmAttacher.attach();
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
