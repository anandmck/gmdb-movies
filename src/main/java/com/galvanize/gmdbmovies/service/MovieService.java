package com.galvanize.gmdbmovies.service;

import java.util.List;
import java.util.Optional;

import com.galvanize.gmdbmovies.domain.criteria.MovieCriteria;
import com.galvanize.gmdbmovies.domain.error.MovieNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.galvanize.gmdbmovies.domain.model.Movie;
import com.galvanize.gmdbmovies.repo.MovieRepository;

@Service
public class MovieService {

    private final static Logger LOG = LoggerFactory.getLogger("movie.service");
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    public List<Movie> find() {

        return find(null);
    }

    public List<Movie> find(MovieCriteria criteria) {

        List<Movie> movies = search(criteria);

        LOG.debug("[MOVIES]: {} movie(s) found ({})", movies.size(), criteria);

        return movies;
    }

    public Optional<Movie> findByMovieId(Long id) throws MovieNotFoundException {

        Optional<Movie> movie = movieRepository.findById(id);

        LOG.debug("[MOVIES]: {} movie with movie id {}", movie.isPresent() ? "Found" : "Did not find", id);

        if (!movie.isPresent())
            throw new MovieNotFoundException("Did not find movie with movie id " + id);

        return movie;
    }

    public Optional<Movie> findByImdbId(String imdbId) throws MovieNotFoundException {

        Optional<Movie> movie = movieRepository.findByImdbId(imdbId);

        LOG.debug("[MOVIES]: {} movie with imdb id {}", movie.isPresent() ? "Found" : "Did not find", imdbId);

        if (!movie.isPresent())
            throw new MovieNotFoundException("Did not find movie with imdb id " + imdbId);

        return movie;
    }

    public List<Movie> findRandom(int quantity) {

        List<Movie> movies = movieRepository.findRandom(quantity);

        LOG.debug("[MOVIES]: {} random movie(s) found", movies.size());

        return movies;
    }

    private List<Movie> search(MovieCriteria criteria) {

        if (criteria == null)
            return movieRepository.findAll();

        switch (criteria.getSearchType()) {

            case ACTOR:
                return movieRepository.findByActorsContaining(criteria.getActor());
            case TITLE:
                return movieRepository.findByTitleContaining(criteria.getTitle());
            case ACTOR_AND_TITLE:
                return movieRepository.findByActorsContainingAndTitleContaining(criteria.getActor(), criteria.getTitle());
            default:
                return movieRepository.findAll();
        }
    }
}