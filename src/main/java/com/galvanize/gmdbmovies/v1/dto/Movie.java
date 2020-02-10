package com.galvanize.gmdbmovies.v1.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Movie {

    private Long movieId;
    private String metascore;
    private String boxOffice;
    private String website;
    private String imdbRating;
    private String imdbVotes;
    private String runtime;
    private String language;
    private String rated;
    private String production;
    private Date released;
    private String imdbId;
    private String plot;
    private String director;
    private String title;
    private String actors;
    private String response;
    private String type;
    private String awards;
    private Date dvd;
    private String year;
    private String poster;
    private String country;
    private String genre;
    private String writer;
    private String desc;
    // List<Review> reviews = new ArrayList<>();
}
