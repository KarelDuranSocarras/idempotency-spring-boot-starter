package io.github.KarelDuranSocarras.idempotency.core.exception;

public class IdempotencyInProgressException extends IdempotencyException {
    public IdempotencyInProgressException(String message) {
        super(message);
    }
}
