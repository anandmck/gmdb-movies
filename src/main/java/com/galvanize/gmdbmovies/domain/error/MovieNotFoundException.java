package com.galvanize.gmdbmovies.domain.error;

public class MovieNotFoundException extends Exception {

    public MovieNotFoundException(String message) {

        super(message);
    }
}
