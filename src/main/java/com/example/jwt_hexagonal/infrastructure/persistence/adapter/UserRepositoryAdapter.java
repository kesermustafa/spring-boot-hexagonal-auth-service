package com.example.jwt_hexagonal.infrastructure.persistence.adapter;

import com.example.jwt_hexagonal.domain.model.User;
import com.example.jwt_hexagonal.domain.port.out.UserRepositoryPort;
import com.example.jwt_hexagonal.infrastructure.persistence.entity.UserEntity;
import com.example.jwt_hexagonal.infrastructure.persistence.mapper.UserMapper;
import com.example.jwt_hexagonal.infrastructure.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaRepository;

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

}
