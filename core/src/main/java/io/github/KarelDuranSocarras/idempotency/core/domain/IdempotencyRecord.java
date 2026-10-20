package io.github.KarelDuranSocarras.idempotency.core.domain;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public record IdempotencyRecord(
        IdempotencyKey key,
        IdempotencyStatus status,
        Object response,
        int responseStatus,
        Map<String, String> replayableHeaders,
        Instant createdAt,
        Instant completedAt,
        Instant expiresAt
) {
    public IdempotencyRecord {
        Objects.requireNonNull(key, "key must not be null");
        Objects.requireNonNull(status, "status must not be null");
        Objects.requireNonNull(createdAt, "createdAt must not be null");
        Objects.requireNonNull(expiresAt, "expiresAt must not be null");
        if (replayableHeaders == null) {
            replayableHeaders = Collections.emptyMap();
        } else {
            replayableHeaders = Collections.unmodifiableMap(replayableHeaders);
        }
    }
}
