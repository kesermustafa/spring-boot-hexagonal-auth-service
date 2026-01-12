package com.example.jwt_hexagonal.domain.model;

import com.example.jwt_hexagonal.domain.model.enums.Role;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private UUID id;

    private String email;

    private String password;

    private Role role;

    private boolean enabled = true;


    public static User create(String email, String encodedPassword) {
        return new User(
                UUID.randomUUID(),
                email,
                encodedPassword,
                Role.CUSTOMER,
                true
        );
    }

}