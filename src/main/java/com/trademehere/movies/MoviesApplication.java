package com.trademehere.movies;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import co.elastic.apm.attach.ElasticApmAttacher;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.put("service_name", System.getenv("ELASTIC_APM_SERVICE_NAME"));
		configuration.put("server_urls", System.getenv("ELASTIC_APM_SERVERS_URL"));
		configuration.put("secret_token", System.getenv("ELASTIC_APM_SECRET_TOKEN"));
		configuration.put("application_packages", "com.trademehere.movies");
		configuration.put("environment", System.getenv("ELASTIC_APM_ENVIRONMENT"));
		configuration.put("enable_log_correlation","true");
		
		
		ElasticApmAttacher.attach(configuration);
		SpringApplication.run(MoviesApplication.class, args);
	}

}
