package com.trademehere.movies.controller.api;

import java.util.UUID;

import com.trademehere.movies.dto.model.Greeting;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello-world")
@Slf4j
public class HelloWorldController {
	
    
    @GetMapping("/ok")
    public ResponseEntity<Greeting> sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
    	log.info("An INFO Message");
        Greeting grettings = new Greeting();
        grettings.setId(UUID.randomUUID().toString());
        grettings.setContent(name);
        return new ResponseEntity<>(grettings,HttpStatus.OK);
    }

    @GetMapping("/not-found")
    public ResponseEntity<Greeting> sayHelloNotFound(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting grettings = new Greeting();
        grettings.setId(UUID.randomUUID().toString());
        grettings.setContent(name);
        return new ResponseEntity<>(grettings,HttpStatus.NOT_FOUND);
    }
}
