package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.dto.ExpenseDto;
import com.budgeting.burdgetmanagement.entity.*;
import com.budgeting.burdgetmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    HttpServletRequest request;
    public List<ExpenseEntity> findAll() {
        Long userId = (Long) request.getAttribute("userId");
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return expenseRepository.findAllByUser(user);
    }
    public Optional<ExpenseEntity> findOne(Long id){
        return expenseRepository.findById(id);
    }
    public ExpenseEntity saveExpense(ExpenseDto expense){
        Long userId = (Long) request.getAttribute("userId");
        UserEntity user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Account not found"));
        CategoryEntity category = categoryRepository.findById(expense.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        AccountEntity account = accountRepository.findById(expense.getAccountId()).orElseThrow(()-> new RuntimeException("Account not found"));
        SubCategoryEntity subCategory = subCategoryRepository.findById(expense.getSubCategoryId()).orElseThrow(()-> new RuntimeException("Subcategory not found"));
        ExpenseEntity expenseEntity = new ExpenseEntity();
        expenseEntity.setUser(user);
        expenseEntity.setCategory(category);
        expenseEntity.setAccount(account);
        expenseEntity.setSubCategory(subCategory);
        expenseEntity.setExpenseAmount(expense.getExpenseAmount());
        expenseEntity.setExpenseDescription(expense.getExpenseDescription());
        expenseEntity.setExpenseDate(expense.getExpenseDate());
        expenseEntity.setExpenseFrequency(expense.getExpenseFrequency());
        expenseEntity.setEndDate(expense.getEndDate());
        expenseEntity.setProcessed(expense.getProcessed());
        expenseEntity.setCreatedAt(LocalDateTime.now());
        return  expenseRepository.save(expenseEntity);
    }
    public void deleteExpense(Long id){
         expenseRepository.deleteById(id);
    }
    public ExpenseEntity updateExpense(Long id, ExpenseDto expenseDto){
        ExpenseEntity existingExpense = expenseRepository.findById(id).orElseThrow(()-> new RuntimeException("Expense not found"));
        CategoryEntity category = categoryRepository.findById(expenseDto.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        AccountEntity account = accountRepository.findById(expenseDto.getAccountId()).orElseThrow(()-> new RuntimeException("Account not found"));
        SubCategoryEntity subCategory = subCategoryRepository.findById(expenseDto.getSubCategoryId()).orElseThrow(()-> new RuntimeException("Subcategory not found"));
        existingExpense.setCategory(category);
        existingExpense.setAccount(account);
        existingExpense.setSubCategory(subCategory);
        existingExpense.setExpenseAmount(expenseDto.getExpenseAmount());
        existingExpense.setExpenseDescription(expenseDto.getExpenseDescription());
        existingExpense.setExpenseDate(expenseDto.getExpenseDate());
        existingExpense.setEndDate(expenseDto.getEndDate());
        existingExpense.setProcessed(expenseDto.getProcessed());
        return expenseRepository.save(existingExpense);
    }

}
