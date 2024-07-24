package com.budgeting.burdgetmanagement.repository;

import com.budgeting.burdgetmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Override
    Optional<UserEntity> findById(Long userId);
    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findByUserNameAndPassword(String username, String password);
}
