package io.github.KarelDuranSocarras.idempotency.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BodyHasherTest {
    @Test
    void deterministic() {
        String h1 = BodyHasher.hash("test");
        String h2 = BodyHasher.hash("test");
        assertEquals(h1, h2);
    }

    @Test
    void differentInputDifferentHash() {
        String h1 = BodyHasher.hash("test1");
        String h2 = BodyHasher.hash("test2");
        assertFalse(h1.equals(h2));
    }

    @Test
    void hashEmptyDoesNotThrow() {
        String h = BodyHasher.hash("");
        assertNotNull(h);
    }
}
