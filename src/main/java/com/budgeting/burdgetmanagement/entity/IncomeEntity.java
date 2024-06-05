package com.budgeting.burdgetmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "income")
@Data
@NoArgsConstructor
public class IncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
    private String incomeDescription;
    private Double incomeAmount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
    private LocalDate incomeDate;
    private LocalDate endDate;
    private Integer incomeFrequency;
    private LocalDateTime createdAt;


}
