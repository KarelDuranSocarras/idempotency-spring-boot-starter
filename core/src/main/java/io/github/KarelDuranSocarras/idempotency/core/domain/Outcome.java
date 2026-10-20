package io.github.KarelDuranSocarras.idempotency.core.domain;

public sealed interface Outcome permits
        Outcome.Fresh,
        Outcome.Replayed,
        Outcome.Concurrent,
        Outcome.BodyMismatch {

    record Fresh() implements Outcome {
    }

    record Replayed(Object response) implements Outcome {
    }

    record Concurrent() implements Outcome {
    }

    record BodyMismatch(String storedBodyHash, String incomingBodyHash) implements Outcome {
    }
}
