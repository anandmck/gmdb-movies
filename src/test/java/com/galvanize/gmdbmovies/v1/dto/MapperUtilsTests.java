package com.galvanize.gmdbmovies.v1.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.galvanize.gmdbmovies.domain.util.MapperUtils;

class MapperUtilsTests {

    @Test
    void map() {

        com.galvanize.gmdbmovies.domain.model.Movie model = createTestMovie(1L, "II1", "Title #1");
        com.galvanize.gmdbmovies.v1.dto.Movie dto = MapperUtils.map(model, com.galvanize.gmdbmovies.v1.dto.Movie.class);

        assertEquals(dto.getMovieId(), 1L);
        assertEquals(dto.getImdbId(), "II1");
        assertEquals(dto.getTitle(), "Title #1");
    }

    @Test
    void mapAll() {

        int quantity = 5;

        List<com.galvanize.gmdbmovies.domain.model.Movie> models = createTestMovies(quantity);
        List<com.galvanize.gmdbmovies.v1.dto.Movie> dtos = MapperUtils.mapAll(models, com.galvanize.gmdbmovies.v1.dto.Movie.class);

        assertEquals(models.size(), dtos.size());

        for (int i = 0; i < quantity; i++) {

            com.galvanize.gmdbmovies.domain.model.Movie model = models.get(i);
            com.galvanize.gmdbmovies.v1.dto.Movie dto = dtos.get(i);

            assertEquals(model.getMovieId(), dto.getMovieId());
            assertEquals(model.getImdbId(), dto.getImdbId());
            assertEquals(model.getTitle(), dto.getTitle());
        }
    }

    @Test
    void mapOptional() {

        Optional<com.galvanize.gmdbmovies.domain.model.Movie> model = Optional.empty();
        Optional<com.galvanize.gmdbmovies.v1.dto.Movie> dto = MapperUtils.mapOptional(model, com.galvanize.gmdbmovies.v1.dto.Movie.class);

        assertTrue(!dto.isPresent());
    }

    private com.galvanize.gmdbmovies.domain.model.Movie createTestMovie(Long movieId, String imdbId, String title) {

        com.galvanize.gmdbmovies.domain.model.Movie movie = new com.galvanize.gmdbmovies.domain.model.Movie();

        movie.setMovieId(movieId);
        movie.setImdbId(imdbId);
        movie.setTitle(title);

        return movie;
    }

    private List<com.galvanize.gmdbmovies.domain.model.Movie> createTestMovies(int quantity) {

        List<com.galvanize.gmdbmovies.domain.model.Movie> movies = new ArrayList<>();

        for (long i = 0; i < quantity; i++) {

            com.galvanize.gmdbmovies.domain.model.Movie movie = createTestMovie(i, "Title #" + i, "II" + i);

            movies.add(movie);
        }

        return movies;
    }
}