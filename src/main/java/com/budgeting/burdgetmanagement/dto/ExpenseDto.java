package com.budgeting.burdgetmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class ExpenseDto {
    private Long expenseId;
    private Long categoryId;
    private Long subCategoryId;
    private Long accountId;
    private double expenseAmount;
    private String expenseDescription;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate expenseDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Integer expenseFrequency;
    private Integer processed;


}

