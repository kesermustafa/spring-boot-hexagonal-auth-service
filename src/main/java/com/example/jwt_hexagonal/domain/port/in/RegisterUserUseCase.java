package com.example.jwt_hexagonal.domain.port.in;

import com.example.jwt_hexagonal.domain.model.User;

public interface RegisterUserUseCase {

    User register(String email, String password);
}
