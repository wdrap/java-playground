package dev.wdrap.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

class BookValidationTest {

    @Test
    void book_passesValidation() {
        var b = new Book("title",
                "author",
                LocalDate.of(2023,1,1),
                "1234567890",
                "1234567890123",
                Collections.emptyList(),
                "filename");

        var result = BookValidation.hasTitle()
                .and(BookValidation.isValidIsbn10())
                .apply(b);

        Assertions.assertTrue(result.isValid());
        Assertions.assertEquals(result.getReason(), Optional.empty());
    }

    @Test
    void book_withoutTitle_failsValidation() {
        var b = new Book("",
                "author",
                LocalDate.of(2023,1,1),
                "123456789",
                "1234567890123",
                Collections.emptyList(),
                "filename");

        var result = BookValidation.hasTitle()
                .and(BookValidation.isValidIsbn10())
                .apply(b);

        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals(result.getReason(), Optional.of("Book has no title."));
    }
}
