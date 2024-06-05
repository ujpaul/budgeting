package com.budgeting.burdgetmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class IncomeDto {
    private Long accountId;
    private String incomeDescription;
    private Double incomeAmount;
    private Integer incomeFrequency;
    private LocalDate incomeDate;
    private LocalDate endDate;
}
