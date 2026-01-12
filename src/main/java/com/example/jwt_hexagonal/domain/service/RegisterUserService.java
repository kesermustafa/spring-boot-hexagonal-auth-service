package com.example.jwt_hexagonal.domain.service;

import com.example.jwt_hexagonal.domain.model.User;
import com.example.jwt_hexagonal.domain.port.in.RegisterUserUseCase;
import com.example.jwt_hexagonal.domain.port.out.PasswordEncoderPort;
import com.example.jwt_hexagonal.domain.port.out.UserRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;

    @Override
    public void register(String email, String password) {

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = User.create(email, encodedPassword);

        userRepository.save(user);
    }


}
