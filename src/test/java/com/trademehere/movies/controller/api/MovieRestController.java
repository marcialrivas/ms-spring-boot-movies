package com.trademehere.movies.controller.api;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MovieRestControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void shouldReturnOkResponse() throws Exception {
    this.mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("id")));
  }

  @Test
  void shouldReturnNotFound() throws Exception {
    this.mockMvc.perform(get("/movies/1")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("6073468e250c2ca9450caf68")));
  }

}