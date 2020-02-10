package com.galvanize.gmdbmovies.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "MOVIES")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", unique = true, nullable = false)
    private Long movieId;

    @Column(name="METASCORE")
    private String metascore;

    @Column(name="BOXOFFICE")
    private String boxOffice;

    @Column(name="WEBSITE")
    private String website;

    @Column(name="IMDB_RATING")
    private String imdbRating;

    @Column(name="IMDB_VOTES")
    private String imdbVotes;

    @Column(name="RUNTIME")
    private String runtime;

    @Column(name="LANGUAGE")
    private String language;

    @Column(name="RATED")
    private String rated;

    @Column(name="PRODUCTION")
    private String production;

    @Column(columnDefinition = "date", name="RELEASED")
    @JsonFormat(pattern = "dd MMM yyyy")
    private Date released;

    @Column(name="IMDBID")
    private String imdbId;

    @Column(name="PLOT",columnDefinition = "LONGTEXT")
    private String plot;

    @Column(name="DIRECTOR")
    private String director;

    @Column(name="TITLE")
    private String title;

    @Column(name="ACTORS")
    private String actors;

    @Column(name="RESPONSE")
    private String response;

    @Column(name="TYPE")
    private String type;

    @Column(name="AWARDS")
    private String awards;

    @Column(columnDefinition = "date", name="DVD")
    @JsonFormat(pattern = "dd MMM yyyy")
    private Date dvd;

    @Column(name="YEAR")
    private String year;

    @Column(name="POSTER")
    private String poster;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="GENRE")
    private String genre;

    @Column(name="WRITER", columnDefinition = "LONGTEXT")
    private String writer;

//    @OneToMany(mappedBy = "movie", orphanRemoval = true, cascade = CascadeType.ALL)
//    @JsonIgnore
//    List<Review> reviews = new ArrayList<>();
}
