package com.example.jwt_hexagonal.domain.port.out;

public interface PasswordEncoderPort {
    String encode(String rawPassword);

    boolean matches(String raw, String encoded);
}
