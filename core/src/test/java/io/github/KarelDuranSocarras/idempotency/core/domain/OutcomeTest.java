package io.github.KarelDuranSocarras.idempotency.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutcomeTest {
    @Test
    void switchPatternMatchingExhaustiveCompiles() {
        Outcome o1 = new Outcome.Fresh();
        Outcome o2 = new Outcome.Replayed("response");
        Outcome o3 = new Outcome.Concurrent();
        Outcome o4 = new Outcome.BodyMismatch("a", "b");

        String r1 = switch (o1) {
            case Outcome.Fresh f -> "fresh";
            case Outcome.Replayed r -> "replayed";
            case Outcome.Concurrent c -> "concurrent";
            case Outcome.BodyMismatch m -> "mismatch";
        };
        String r2 = switch (o2) {
            case Outcome.Fresh f -> "fresh";
            case Outcome.Replayed r -> "replayed";
            case Outcome.Concurrent c -> "concurrent";
            case Outcome.BodyMismatch m -> "mismatch";
        };
        String r3 = switch (o3) {
            case Outcome.Fresh f -> "fresh";
            case Outcome.Replayed r -> "replayed";
            case Outcome.Concurrent c -> "concurrent";
            case Outcome.BodyMismatch m -> "mismatch";
        };
        String r4 = switch (o4) {
            case Outcome.Fresh f -> "fresh";
            case Outcome.Replayed r -> "replayed";
            case Outcome.Concurrent c -> "concurrent";
            case Outcome.BodyMismatch m -> "mismatch";
        };
        assertNotNull(r1);
        assertNotNull(r2);
        assertNotNull(r3);
        assertNotNull(r4);
    }
}
