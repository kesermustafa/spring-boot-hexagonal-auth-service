package com.example.jwt_hexagonal.domain.service;

import com.example.jwt_hexagonal.domain.model.User;
import com.example.jwt_hexagonal.domain.model.enums.Role;
import com.example.jwt_hexagonal.domain.port.in.RegisterUserUseCase;
import com.example.jwt_hexagonal.domain.port.out.PasswordEncoderPort;
import com.example.jwt_hexagonal.domain.port.out.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;

    @Override
    public User register(String email, String password) {

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .password(encodedPassword)
                .role(Role.CUSTOMER)
                .enabled(true)
                .build();

        return userRepository.save(user);
    }


}
