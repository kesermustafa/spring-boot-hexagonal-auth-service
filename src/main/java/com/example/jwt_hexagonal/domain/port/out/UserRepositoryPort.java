package com.example.jwt_hexagonal.domain.port.out;

import com.example.jwt_hexagonal.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {


    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID id);

    boolean existsByEmail(String email);
}
