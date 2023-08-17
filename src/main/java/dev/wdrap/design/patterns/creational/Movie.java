package dev.wdrap.design.patterns.creational;

import java.time.LocalDate;
import java.util.List;

import dev.wdrap.design.patterns.creational.builder.MovieBuilder;

public record Movie(String title,
                    LocalDate releasesDate,
                    String genre,
                    List<String> actors) {

    public static MovieBuilder.MovieReleaseDate title(String title) {
        return MovieBuilder.title(title);
    }
}
