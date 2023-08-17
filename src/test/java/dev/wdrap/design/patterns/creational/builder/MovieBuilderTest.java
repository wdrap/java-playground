package dev.wdrap.design.patterns.creational.builder;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.wdrap.design.patterns.creational.Movie;

public class MovieBuilderTest {

    @Test
    void shouldCreateMovie() {
        var a = Movie.title("Cars")
        .releaseDate(LocalDate.now())
        .genre("Cartoon")
        .actor("Leon")
        .actor("sien")
        .build();

        System.out.println(a);
        Assertions.assertNotNull(a);
    }
}
