package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.dto.IncomeDto;
import com.budgeting.burdgetmanagement.entity.AccountEntity;
import com.budgeting.burdgetmanagement.entity.IncomeEntity;
import com.budgeting.burdgetmanagement.repository.AccountRepository;
import com.budgeting.burdgetmanagement.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private AccountRepository accountRepository;
    public List<IncomeEntity> findAll(){
        return incomeRepository.findAll();
    }
    public Optional<IncomeEntity> findOne(Long id){
        return incomeRepository.findById(id);
    }
    public IncomeEntity saveIncome(IncomeDto incomeDto){
        AccountEntity account = accountRepository.findById(incomeDto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        IncomeEntity income = new IncomeEntity();
        income.setIncomeDescription(incomeDto.getIncomeDescription());
        income.setIncomeAmount(incomeDto.getIncomeAmount());
        income.setAccount(account);
        income.setIncomeFrequency(incomeDto.getIncomeFrequency());
        income.setIncomeDate(incomeDto.getIncomeDate());
        income.setEndDate(incomeDto.getEndDate());

        return incomeRepository.save(income);
    }

    public IncomeEntity updateIncome(Long id, IncomeDto incomeDto){
        IncomeEntity existingIncome = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        AccountEntity account = accountRepository.findById(incomeDto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        existingIncome.setIncomeDescription(incomeDto.getIncomeDescription());
        existingIncome.setIncomeAmount(incomeDto.getIncomeAmount());
        existingIncome.setAccount(account);
        existingIncome.setIncomeDate(incomeDto.getIncomeDate());
        existingIncome.setIncomeFrequency(incomeDto.getIncomeFrequency());
        existingIncome.setEndDate(incomeDto.getEndDate());
        return incomeRepository.save(existingIncome);
    }
    public void deleteIncome(Long id){
        incomeRepository.deleteById(id);
    }

}
