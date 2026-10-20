package io.github.KarelDuranSocarras.idempotency.core.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class BodyHasher {
    private BodyHasher() {
    }

    public static String hash(byte[] bytes) {
        if (bytes == null) {
            return hash(new byte[0]);
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashed = digest.digest(bytes);
            StringBuilder sb = new StringBuilder(hashed.length * 2);
            for (byte b : hashed) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 not available", e);
        }
    }

    public static String hash(String value) {
        if (value == null) {
            return hash(new byte[0]);
        }
        return hash(value.getBytes(StandardCharsets.UTF_8));
    }
}
