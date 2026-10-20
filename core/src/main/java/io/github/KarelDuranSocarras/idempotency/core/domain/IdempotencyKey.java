package io.github.KarelDuranSocarras.idempotency.core.domain;

import java.util.Objects;

public record IdempotencyKey(String value, String bodyHash) {
    public IdempotencyKey {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("idempotency key value must not be null or blank");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("idempotency key value must be <= 255 chars");
        }
        Objects.requireNonNull(bodyHash, "bodyHash must not be null");
    }

    public static IdempotencyKey of(String value, String bodyHash) {
        return new IdempotencyKey(value, bodyHash);
    }
}
