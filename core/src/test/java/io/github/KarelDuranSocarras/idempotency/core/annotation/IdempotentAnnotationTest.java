package io.github.KarelDuranSocarras.idempotency.core.annotation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class IdempotentAnnotationTest {
    @Idempotent
    public void sample() {
    }

    @Test
    void defaults() throws Exception {
        Method method = IdempotentAnnotationTest.class.getMethod("sample");
        Idempotent ann = method.getAnnotation(Idempotent.class);
        assertNotNull(ann);
        assertEquals("Idempotency-Key", ann.keyHeader());
        assertEquals("", ann.key());
        assertEquals(86400L, ann.ttlSeconds());
        assertTrue(ann.validateBody());
        assertArrayEquals(new String[]{}, ann.ignoreHeaders());
        assertTrue(ann.cacheResponseBody());
        assertTrue(ann.failOnBodyMismatch());
    }
}
