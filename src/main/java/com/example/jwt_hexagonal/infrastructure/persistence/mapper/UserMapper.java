package com.example.jwt_hexagonal.infrastructure.persistence.mapper;


import com.example.jwt_hexagonal.domain.model.User;
import com.example.jwt_hexagonal.infrastructure.persistence.entity.UserEntity;

public final class UserMapper {

    private UserMapper() {
        // util class
    }

    /* ===============================
       Domain → Entity
       =============================== */
    public static UserEntity toEntity(User user) {

        if (user == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());
        entity.setEnabled(user.isEnabled());

        return entity;
    }

    /* ===============================
       Entity → Domain
       =============================== */
    public static User toDomain(UserEntity entity) {

        if (entity == null) {
            return null;
        }

        return new User(
                entity.getId(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole(),
                entity.isEnabled()
        );
    }
}
