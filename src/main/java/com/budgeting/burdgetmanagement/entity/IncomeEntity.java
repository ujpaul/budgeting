package com.budgeting.burdgetmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "income")
public class IncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
    private String incomeDescription;
    private Double incomeAmount;

    @JsonIgnoreProperties("income")
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    private LocalDate incomeDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "user_id")
    private UserEntity user;
    private LocalDate endDate;
    private Integer incomeFrequency;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    private Integer processed;
    private LocalDateTime createdAt;

    // Getters and Setters
    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getIncomeFrequency() {
        return incomeFrequency;
    }

    public void setIncomeFrequency(Integer incomeFrequency) {
        this.incomeFrequency = incomeFrequency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "IncomeEntity{" +
                "incomeId=" + incomeId +
                ", incomeDescription='" + incomeDescription + '\'' +
                ", incomeAmount=" + incomeAmount +
                ", account=" + account +
                ", incomeDate=" + incomeDate +
                ", endDate=" + endDate +
                ", incomeFrequency=" + incomeFrequency +
                ", createdAt=" + createdAt +
                '}';
    }
}
