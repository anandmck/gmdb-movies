package com.galvanize.gmdbmovies.v1.endpoint;

import java.util.List;
import java.util.Optional;

import com.galvanize.gmdbmovies.domain.criteria.MovieCriteria;
import com.galvanize.gmdbmovies.domain.error.MovieNotFoundException;
import com.galvanize.gmdbmovies.domain.rest.RestEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.galvanize.gmdbmovies.domain.util.MapperUtils;
import com.galvanize.gmdbmovies.service.MovieService;
import com.galvanize.gmdbmovies.v1.dto.Movie;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "v1/movies", produces = { MediaType.APPLICATION_JSON_VALUE })
public class MovieEndpoint extends RestEndpoint {

    private final static Logger LOG = LoggerFactory.getLogger("movie.endpoint.v1");
    private final MovieService movieService;
    
    public MovieEndpoint(MovieService movieService) {

        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> find(@Valid MovieCriteria criteria) {

        List<Movie> result = MapperUtils.mapAll(movieService.find(criteria), Movie.class);

        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getById(@PathVariable Long id) throws MovieNotFoundException {

        Optional<Movie> movie = MapperUtils.mapOptional(movieService.findByMovieId(id), Movie.class);

        return ResponseEntity.ok(movie.get());
    }

    @GetMapping("imdb/{imdbId}")
    public ResponseEntity<Movie> getByImdbId(@PathVariable String imdbId) throws MovieNotFoundException {

        Optional<Movie> movie = MapperUtils.mapOptional(movieService.findByImdbId(imdbId), Movie.class);

        return ResponseEntity.ok(movie.get());
    }

    @GetMapping("random")
    public ResponseEntity<List<Movie>> getRandom(@RequestParam(required = false, defaultValue = "5") int quantity) {

        List<Movie> movies = MapperUtils.mapAll(movieService.findRandom(quantity), Movie.class);

        return ResponseEntity.ok(movies);
    }
}