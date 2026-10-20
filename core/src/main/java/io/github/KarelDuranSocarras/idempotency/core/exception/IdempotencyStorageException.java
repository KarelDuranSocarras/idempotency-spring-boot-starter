package io.github.KarelDuranSocarras.idempotency.core.exception;

public class IdempotencyStorageException extends IdempotencyException {
    public IdempotencyStorageException(String message) {
        super(message);
    }

    public IdempotencyStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
