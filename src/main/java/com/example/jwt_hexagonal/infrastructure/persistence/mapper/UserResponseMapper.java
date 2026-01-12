package com.example.jwt_hexagonal.infrastructure.persistence.mapper;

import com.example.jwt_hexagonal.application.dto.response.UserResponse;
import com.example.jwt_hexagonal.domain.model.User;

public final class UserResponseMapper {

    private UserResponseMapper() {}

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getRole().name(),
                user.isEnabled()
        );
    }

}
