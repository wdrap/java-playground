package dev.wdrap.domain;

import dev.wdrap.domain.validation.Validator;

import static dev.wdrap.domain.validation.Validator.holds;

public interface BookValidation extends Validator<Book> {

    static Validator<Book> hasTitle() {
        return holds(book -> book.title().isBlank(), "Book has no title.");
    }

    static Validator<Book> isValidIsbn10() {
        return holds(book -> book.isbn10().length() != 10, "isbn10 has not correct length.");
    }
}
