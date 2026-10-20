package io.github.KarelDuranSocarras.idempotency.core.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExceptionHierarchyTest {
    @Test
    void allInheritFromIdempotencyExceptionAndRuntime() {
        assertTrue(RuntimeException.class.isAssignableFrom(IdempotencyException.class));
        assertTrue(IdempotencyException.class.isAssignableFrom(IdempotencyKeyMissingException.class));
        assertTrue(IdempotencyException.class.isAssignableFrom(IdempotencyKeyInvalidException.class));
        assertTrue(IdempotencyException.class.isAssignableFrom(IdempotencyInProgressException.class));
        assertTrue(IdempotencyException.class.isAssignableFrom(IdempotencyBodyMismatchException.class));
        assertTrue(IdempotencyException.class.isAssignableFrom(IdempotencyConflictException.class));
        assertTrue(IdempotencyException.class.isAssignableFrom(IdempotencyStorageException.class));
        assertTrue(IdempotencyException.class.isAssignableFrom(IdempotencyConfigurationException.class));
    }
}
