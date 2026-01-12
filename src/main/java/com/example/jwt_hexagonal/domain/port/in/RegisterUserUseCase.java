package com.example.jwt_hexagonal.domain.port.in;

public interface RegisterUserUseCase {

    void register(String email, String password);
}
