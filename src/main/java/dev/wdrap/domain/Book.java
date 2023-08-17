package dev.wdrap.domain;

import java.time.LocalDate;
import java.util.List;

public record Book(String title,
                   String author,
                   LocalDate releaseDate,
                   String isbn10,
                   String isbn13,
                   List<String> categories,
                   String fileName) {

}
