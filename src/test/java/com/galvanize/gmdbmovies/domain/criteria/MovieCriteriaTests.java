package com.galvanize.gmdbmovies.domain.criteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.galvanize.gmdbmovies.domain.criteria.MovieCriteria.SearchType;

class MovieCriteriaTests {

    @Test
    void getSearchType() {

        MovieCriteria criteria = new MovieCriteria();

        assertEquals(criteria.getSearchType(), SearchType.NO_CRITERIA);

        criteria.setActor("Chris Pratt");

        assertEquals(SearchType.ACTOR, criteria.getSearchType());
        assertEquals("Chris Pratt", criteria.getActor());
        assertEquals("search actor: 'Chris Pratt'", criteria.toString());

        criteria.setTitle("Star Trek");

        assertEquals(SearchType.ACTOR_AND_TITLE, criteria.getSearchType());
        assertEquals("Star Trek", criteria.getTitle());
        assertEquals("search actor: 'Chris Pratt' and title: 'Star Trek'", criteria.toString());

        criteria.setActor(null);

        assertEquals(SearchType.TITLE, criteria.getSearchType());
        assertEquals("Star Trek", criteria.getTitle());
        assertEquals("search title: 'Star Trek'", criteria.toString());

    }

    @Test
    void getSearchTypeValue() {

        assertEquals("None", SearchType.NO_CRITERIA.getValue());

        assertEquals("Actor", SearchType.ACTOR.getValue());

        assertEquals("Title", SearchType.TITLE.getValue());

        assertEquals("Actor and Title", SearchType.ACTOR_AND_TITLE.getValue());
    }

    @Test
    void getSearchTypeToString() {

        assertEquals("None", SearchType.NO_CRITERIA.toString());

        assertEquals("Actor", SearchType.ACTOR.toString());

        assertEquals("Title", SearchType.TITLE.toString());

        assertEquals("Actor and Title", SearchType.ACTOR_AND_TITLE.toString());
    }
}