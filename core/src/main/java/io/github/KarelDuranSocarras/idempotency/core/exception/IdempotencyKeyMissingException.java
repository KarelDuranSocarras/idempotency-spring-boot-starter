package io.github.KarelDuranSocarras.idempotency.core.exception;

public class IdempotencyKeyMissingException extends IdempotencyException {
    public IdempotencyKeyMissingException(String message) {
        super(message);
    }
}
