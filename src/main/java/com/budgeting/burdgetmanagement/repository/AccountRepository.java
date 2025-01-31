package com.budgeting.burdgetmanagement.repository;

import com.budgeting.burdgetmanagement.entity.AccountEntity;
import com.budgeting.burdgetmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findAllByUser(UserEntity user);
    Optional<AccountEntity> findById(Long id);
}
