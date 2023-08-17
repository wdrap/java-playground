package dev.wdrap.domain.validation;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Validator<T> extends Function<T, ValidationResult> {

    static <T> Validator<T> holds(Predicate<T> predicate, String message) {
        return t -> predicate.test(t) ? ValidationResult.invalid(message) : ValidationResult.valid();
    }

    default Validator<T> and(Validator<T> other) {
        Objects.requireNonNull(other);
        return t -> {
            var result = this.apply(t);
            if (result.isValid()) {
                return other.apply(t);
            }
            return result;
        };
    }

}
