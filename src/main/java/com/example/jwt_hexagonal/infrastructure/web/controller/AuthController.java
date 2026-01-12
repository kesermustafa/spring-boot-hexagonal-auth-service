package com.example.jwt_hexagonal.infrastructure.web.controller;

import com.example.jwt_hexagonal.application.dto.request.RegisterRequest;
import com.example.jwt_hexagonal.application.dto.response.ApiResponse;
import com.example.jwt_hexagonal.application.dto.response.UserResponse;
import com.example.jwt_hexagonal.domain.model.User;
import com.example.jwt_hexagonal.domain.port.in.RegisterUserUseCase;
import com.example.jwt_hexagonal.infrastructure.persistence.mapper.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@RequestBody RegisterRequest request) {

       User user = registerUserUseCase.register(request.email(), request.password());

       UserResponse userResponse = UserResponseMapper.toResponse(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "User registered successfully",
                        userResponse
                ));

    }

}
