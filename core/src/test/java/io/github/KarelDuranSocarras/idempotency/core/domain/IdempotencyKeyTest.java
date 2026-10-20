package io.github.KarelDuranSocarras.idempotency.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdempotencyKeyTest {
    @Test
    void nullValueThrows() {
        assertThrows(IllegalArgumentException.class, () -> new IdempotencyKey(null, ""));
    }

    @Test
    void blankValueThrows() {
        assertThrows(IllegalArgumentException.class, () -> new IdempotencyKey("   ", ""));
    }

    @Test
    void valueTooLongThrows() {
        String longValue = "a".repeat(256);
        assertThrows(IllegalArgumentException.class, () -> new IdempotencyKey(longValue, ""));
    }

    @Test
    void bodyHashNullIsNotAllowedByRequireNonNull() {
        assertThrows(NullPointerException.class, () -> new IdempotencyKey("key", null));
    }

    @Test
    void validKeyWithEmptyBodyHash() {
        IdempotencyKey key = new IdempotencyKey("key", "");
        assertEquals("key", key.value());
        assertEquals("", key.bodyHash());
    }
}
