package dev.wdrap.domain.validation;

import java.util.Optional;

public interface ValidationResult {
    boolean isValid();

    Optional<String> getReason();

    static ValidationResult valid() {
        return Valid.valid();
    }

    static ValidationResult invalid(String reason) {
        return new Invalid(reason);
    }
}

final class Invalid implements ValidationResult {
    private final String reason;

    Invalid(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public Optional<String> getReason() {
        return Optional.of(reason);
    }
}

final class Valid {
    private static final ValidationResult valid = new ValidationResult() {
        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public Optional<String> getReason() {
            return Optional.empty();
        }
    };

    static ValidationResult valid() {
        return valid;
    }
}
