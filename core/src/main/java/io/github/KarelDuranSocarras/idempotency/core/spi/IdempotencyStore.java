package io.github.KarelDuranSocarras.idempotency.core.spi;

import io.github.KarelDuranSocarras.idempotency.core.domain.IdempotencyKey;
import io.github.KarelDuranSocarras.idempotency.core.domain.IdempotencyRecord;
import io.github.KarelDuranSocarras.idempotency.core.domain.Outcome;

import java.util.Map;
import java.util.Optional;

public interface IdempotencyStore {
    /**
     * Attempts to acquire the given key in IN_PROGRESS state (first request).
     * Must be atomic per key (store-specific lock/primitive).
     * 
     * @param key key to acquire
     * @param ttlSeconds TTL in seconds for the record
     * @return Outcome distinguishing Fresh, Replayed, Concurrent, or BodyMismatch
     */
    Outcome acquire(IdempotencyKey key, long ttlSeconds);

    /**
     * Marks the record as COMPLETED and stores the response data.
     * Must only transition from IN_PROGRESS to COMPLETED. If the record is not in
     * IN_PROGRESS, the implementation must treat as conflict/invariant violation.
     * 
     * @param key key to complete
     * @param response response object to cache
     * @param responseStatus HTTP response status
     * @param replayableHeaders allowlisted headers to replay
     * @param ttlSeconds TTL in seconds to maintain
     */
    void complete(IdempotencyKey key, Object response, int responseStatus,
                  Map<String, String> replayableHeaders, long ttlSeconds);

    /**
     * Releases the key if still in IN_PROGRESS (cleanup on non-retryable failure path).
     * Best-effort; must not throw if key is missing or in different state.
     * 
     * @param key key to release
     */
    void release(IdempotencyKey key);

    /**
     * Loads existing record for key. Returns Optional.empty() if not present or expired.
     * Records with expiresAt &lt; now(UTC) must be treated as absent.
     * 
     * @param key key to load
     * @return Optional containing record if exists and not expired
     */
    Optional<IdempotencyRecord> load(IdempotencyKey key);
}
