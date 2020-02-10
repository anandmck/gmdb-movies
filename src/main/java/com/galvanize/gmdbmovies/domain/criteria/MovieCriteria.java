package com.galvanize.gmdbmovies.domain.criteria;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class MovieCriteria {

    private String actor;

    private String title;

    public SearchType getSearchType() {

        boolean hasActor = StringUtils.hasText(actor);
        boolean hasTitle = StringUtils.hasText(title);

        if (hasActor && hasTitle)
            return SearchType.ACTOR_AND_TITLE;
        else if (hasActor)
            return SearchType.ACTOR;
        else if (hasTitle)
            return SearchType.TITLE;
        else
            return SearchType.NO_CRITERIA;
    }

    @Override
    public String toString() {

        switch (getSearchType()) {

            case ACTOR:
                return String.format("search actor: '%s'", actor);
            case TITLE:
                return String.format("search title: '%s'", title);
            case ACTOR_AND_TITLE:
                return String.format("search actor: '%s' and title: '%s'", actor, title);
            default:
                return String.format("no search criteria");
        }
    }

    public static enum SearchType {

        NO_CRITERIA("None"),
        ACTOR("Actor"),
        TITLE("Title"),
        ACTOR_AND_TITLE("Actor and Title");

        private String value;

        SearchType(String value) {

            this.value = value;
        }

        public String getValue() {

            return value;
        }

        @Override
        public String toString() {

            return value;
        }
    }
}