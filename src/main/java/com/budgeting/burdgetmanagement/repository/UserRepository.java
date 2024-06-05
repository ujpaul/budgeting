package com.budgeting.burdgetmanagement.repository;

import com.budgeting.burdgetmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Override
    Optional<UserEntity> findById(Integer userId);
    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findByUserNameAndPassword(String username, String password);
}
