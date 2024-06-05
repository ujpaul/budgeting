package com.budgeting.burdgetmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
@Data
@NoArgsConstructor
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategoryEntity subCategory;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
    private double expenseAmount;
    private String expenseDescription;
    private Integer expenseFrequency;
    private LocalDate expenseDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;

}
