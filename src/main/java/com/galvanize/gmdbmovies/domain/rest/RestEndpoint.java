package com.galvanize.gmdbmovies.domain.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import lombok.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.galvanize.gmdbmovies.domain.error.MovieNotFoundException;

public class RestEndpoint {

    @Inject
    protected HttpServletRequest request;

    // @Inject
    // protected HttpServletResponse response;

    @ExceptionHandler
    protected ResponseEntity<?> handleMovieNotFoundException(MovieNotFoundException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new JsonResult(HttpStatus.NOT_FOUND, exception.getMessage(), request.getRequestURI()));
    }

    @Data
    private static class JsonResult {

        public JsonResult(HttpStatus status, String message, String path) {

            this.timestamp = new Date();
            this.status = status.value();
            this.error = status.getReasonPhrase();
            this.message = message;
            this.path = path;
        }

        private final Date timestamp;
        private final int status;
        private final String error;
        private final String message;
        private final String path;
    }
}
