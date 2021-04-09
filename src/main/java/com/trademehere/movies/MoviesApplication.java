package com.trademehere.movies;

import org.springframework.boot.SpringApplication;
import co.elastic.apm.attach.ElasticApmAttacher;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trademehere.movies.util.EnviromentVariablesConfig;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		
		ElasticApmAttacher.attach(EnviromentVariablesConfig.getElasctiAMPConfing());
		SpringApplication.run(MoviesApplication.class, args);
	}

}
