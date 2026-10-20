package io.github.KarelDuranSocarras.idempotency.core.exception;

public class IdempotencyConflictException extends IdempotencyException {
    public IdempotencyConflictException(String message) {
        super(message);
    }
}
