package com.budgeting.burdgetmanagement.controller;

import com.budgeting.burdgetmanagement.dto.ExpenseDto;
import com.budgeting.burdgetmanagement.entity.ExpenseEntity;
import com.budgeting.burdgetmanagement.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @GetMapping("")
    public List<ExpenseEntity> getAllexpenses(){
        return expenseService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<ExpenseEntity> getExpense(@PathVariable Long id){
        return expenseService.findOne(id);
    }
    @PostMapping("")
    public ExpenseEntity saveExpense(@RequestBody ExpenseDto expenseDto){
        return expenseService.saveExpense(expenseDto);
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }
    @PutMapping("/{id}")
    public ExpenseEntity updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto){
        return expenseService.updateExpense(id,expenseDto);
    }

}
