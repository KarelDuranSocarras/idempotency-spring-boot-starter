package io.github.KarelDuranSocarras.idempotency.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Idempotent {
    String keyHeader() default "Idempotency-Key";

    String key() default "";

    long ttlSeconds() default 86400L;

    boolean validateBody() default true;

    String[] ignoreHeaders() default {};

    boolean cacheResponseBody() default true;

    boolean failOnBodyMismatch() default true;
}
