package io.github.KarelDuranSocarras.idempotency.core.exception;

public class IdempotencyKeyInvalidException extends IdempotencyException {
    public IdempotencyKeyInvalidException(String message) {
        super(message);
    }
}
