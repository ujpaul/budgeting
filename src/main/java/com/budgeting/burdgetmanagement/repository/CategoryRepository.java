package com.budgeting.burdgetmanagement.repository;

import com.budgeting.burdgetmanagement.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();
    Optional<CategoryEntity> findById(Long id);
}
