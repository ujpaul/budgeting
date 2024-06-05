package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.dto.ExpenseDto;
import com.budgeting.burdgetmanagement.entity.AccountEntity;
import com.budgeting.burdgetmanagement.entity.CategoryEntity;
import com.budgeting.burdgetmanagement.entity.ExpenseEntity;
import com.budgeting.burdgetmanagement.entity.SubCategoryEntity;
import com.budgeting.burdgetmanagement.repository.AccountRepository;
import com.budgeting.burdgetmanagement.repository.CategoryRepository;
import com.budgeting.burdgetmanagement.repository.ExpenseRepository;
import com.budgeting.burdgetmanagement.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ExpenseEntity> findAll(){
        return expenseRepository.findAll();
    }
    public Optional<ExpenseEntity> findOne(Long id){
        return expenseRepository.findById(id);
    }
    public ExpenseEntity saveExpense(ExpenseDto expense){
        System.out.println("Expense payload:" + expense);
        CategoryEntity category = categoryRepository.findById(expense.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        AccountEntity account = accountRepository.findById(expense.getAccountId()).orElseThrow(()-> new RuntimeException("Account not found"));
        SubCategoryEntity subCategory = subCategoryRepository.findById(expense.getSubCategoryId()).orElseThrow(()-> new RuntimeException("Subcategory not found"));
        ExpenseEntity expenseEntity = new ExpenseEntity();
        expenseEntity.setCategory(category);
        expenseEntity.setAccount(account);
        expenseEntity.setSubCategory(subCategory);
        expenseEntity.setExpenseAmount(expense.getExpenseAmount());
        expenseEntity.setExpenseDescription(expense.getExpenseDescription());
        expenseEntity.setExpenseDate(expense.getExpenseDate());
        expenseEntity.setExpenseFrequency(expense.getExpenseFrequency());
        expenseEntity.setEndDate(expense.getEndDate());
        return  expenseRepository.save(expenseEntity);
    }
    public void deleteExpense(Long id){
         expenseRepository.deleteById(id);
    }

}
