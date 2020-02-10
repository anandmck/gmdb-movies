package com.galvanize.gmdbmovies.v1.endpoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MovieEndpointTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void find() throws Exception {

        String url = "/v1/movies";
        mvc.perform(get(url))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {

        String url = "/v1/movies/91";
        mvc.perform(get(url))
            .andDo(print())
            .andExpect(jsonPath("$.movieId").value(91));
    }

    @Test
    void getByImdbId() throws Exception {

        String url = "/v1/movies/imdb/tt0079945";
        mvc.perform(get(url))
            .andDo(print())
            .andExpect(jsonPath("$.imdbId").value("tt0079945"));
    }

    @Test
    void getRandom() throws Exception {

        String url = "/v1/movies/random";
        mvc.perform(get(url))
            .andDo(print())
            .andExpect(status().isOk());
    }
}