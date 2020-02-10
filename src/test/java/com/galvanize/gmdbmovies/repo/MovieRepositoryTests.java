package com.galvanize.gmdbmovies.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.galvanize.gmdbmovies.domain.model.Movie;

@SpringBootTest
class MovieRepositoryTests {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findAll() {

        List<Movie> movies = movieRepository.findAll();

        assertTrue(movies.size() > 0);
    }

    @Test
    void findById() {

        Optional<Movie> movie = movieRepository.findById(97L);

        assertTrue(movie.isPresent());
    }

    @Test
    void findByImdbId() {

        Optional<Movie> movie = movieRepository.findByImdbId("tt3417334");

        assertTrue(movie.isPresent());
    }

    @Test
    void findRandom() {

        List<Movie> movies = movieRepository.findRandom(3);

        assertTrue(movies.size() == 3);
    }
}