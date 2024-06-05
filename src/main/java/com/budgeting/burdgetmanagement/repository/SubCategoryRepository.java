package com.budgeting.burdgetmanagement.repository;

import com.budgeting.burdgetmanagement.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long> {
}
