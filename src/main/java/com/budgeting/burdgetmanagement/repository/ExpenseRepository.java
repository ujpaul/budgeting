package com.budgeting.burdgetmanagement.repository;

import com.budgeting.burdgetmanagement.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {

}
