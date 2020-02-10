package com.galvanize.gmdbmovies.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.galvanize.gmdbmovies.domain.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByImdbId(String imdbId);

    List<Movie> findByActorsContaining(String actor);

    List<Movie> findByTitleContaining(String title);

    List<Movie> findByActorsContainingAndTitleContaining(String actor, String title);

    @Query(value = "SELECT * FROM MOVIES M ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<Movie> findRandom(int quantity);
}