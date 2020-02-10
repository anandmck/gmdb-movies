package com.galvanize.gmdbmovies.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import com.galvanize.gmdbmovies.domain.criteria.MovieCriteria;
import com.galvanize.gmdbmovies.domain.error.MovieNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.galvanize.gmdbmovies.domain.model.Movie;

@SpringBootTest
class MovieServiceTests {

    @Autowired
    private MovieService movieService;

    @Test
    void find() {

        List<Movie> movies = movieService.find();

        assertTrue(movies.size() > 0);

        MovieCriteria criteria = new MovieCriteria();

        movies = movieService.find(criteria);

        assertTrue(movies.size() > 0);

        criteria.setActor("Chris Pine");

        movies = movieService.find(criteria);

        assertTrue(movies.size() > 0);

        criteria.setTitle("Star Trek");

        movies = movieService.find(criteria);

        assertTrue(movies.size() > 0);

        criteria.setActor(null);

        movies = movieService.find(criteria);

        assertTrue(movies.size() > 0);

        criteria.setActor("NO_ACTOR");
        criteria.setTitle("NO_TITLE");

        movies = movieService.find(criteria);

        assertTrue(movies.size() == 0);
    }

    @Test
    void findById() {

        try {

            Optional<Movie> movie = movieService.findByMovieId(97L);

            assertTrue(movie.isPresent());

            movie = movieService.findByMovieId(0L);
        }
        catch (MovieNotFoundException e) {

            assertTrue(e.getLocalizedMessage() != null);
        }
    }

    @Test
    void findByImdbId() {

        try {

            Optional<Movie> movie = movieService.findByImdbId("tt3417334");

            assertTrue(movie.isPresent());

            movie = movieService.findByImdbId("NOT_HERE");
        }
        catch (MovieNotFoundException e) {

            assertTrue(e.getLocalizedMessage() != null);
        }
    }

    @Test
    void findRandom() {

        List<Movie> movies = movieService.findRandom(3);

        assertTrue(movies.size() == 3);
    }
}