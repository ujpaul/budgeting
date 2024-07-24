package com.budgeting.burdgetmanagement.repository;

import com.budgeting.burdgetmanagement.entity.AccountEntity;
import com.budgeting.burdgetmanagement.entity.IncomeEntity;
import com.budgeting.burdgetmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {
    List<IncomeEntity> findAllByUser(UserEntity user);
    public Optional<IncomeEntity> findById(Long id);
}
