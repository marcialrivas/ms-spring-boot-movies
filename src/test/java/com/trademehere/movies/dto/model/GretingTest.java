package com.trademehere.movies.dto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GretingTest {

    @Test
    void testToStrinng(){
        Greeting getting = new Greeting();
        getting.setContent("test content");
        assertTrue(getting.toString().contains("test content"));
    }

    @Test
    void testHashCode(){
        Greeting getting = new Greeting();
        getting.setContent("test content");

        Greeting greeting2 = getting;

        assertEquals(getting.hashCode(), greeting2.hashCode());
    }

    @Test
    void testEquals(){
        Greeting getting = new Greeting();
        getting.setContent("test content");

        Greeting greeting2 = getting;

        assertEquals(getting,greeting2);
    }
}