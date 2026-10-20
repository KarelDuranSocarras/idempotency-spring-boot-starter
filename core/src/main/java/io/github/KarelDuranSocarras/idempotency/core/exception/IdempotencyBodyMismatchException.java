package io.github.KarelDuranSocarras.idempotency.core.exception;

public class IdempotencyBodyMismatchException extends IdempotencyException {
    public IdempotencyBodyMismatchException(String message) {
        super(message);
    }
}
