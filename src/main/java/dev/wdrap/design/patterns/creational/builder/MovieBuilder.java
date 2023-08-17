package dev.wdrap.design.patterns.creational.builder;

import dev.wdrap.design.patterns.creational.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface MovieBuilder {

    static MovieReleaseDate title(String title) {
        Objects.requireNonNull(title);
        return new Builder(title);
    }

    interface MovieReleaseDate {
        MovieGenre releaseDate(LocalDate releaseDate);
    }

    interface MovieGenre {
        MovieActor genre(String genre);
    }

    interface MovieActor {
        Movie build();
        MovieActor actor(String actor);
    }

    class Builder implements MovieReleaseDate, MovieGenre, MovieActor {
        private final String title;
        private LocalDate releaseDate;
        private String genre;
        private final List<String> actors = new ArrayList<>();

        public Builder(String title) {
            this.title = title;
        }

        @Override
        public Movie build() {
            return new Movie(title, releaseDate, genre, actors);
        }


        @Override
        public MovieActor actor(String actor) {
            Objects.requireNonNull(actor);
            this.actors.add(actor);
            return this;
        }

        @Override
        public MovieActor genre(String genre) {
            Objects.requireNonNull(genre);
            this.genre = genre;
            return this;
        }

        @Override
        public MovieGenre releaseDate(LocalDate releaseDate) {
            Objects.requireNonNull(releaseDate);
            this.releaseDate = releaseDate;
            return this;
        }
    }
}
