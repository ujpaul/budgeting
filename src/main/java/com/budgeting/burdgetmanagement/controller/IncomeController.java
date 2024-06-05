package com.budgeting.burdgetmanagement.controller;

import com.budgeting.burdgetmanagement.dto.IncomeDto;
import com.budgeting.burdgetmanagement.entity.IncomeEntity;
import com.budgeting.burdgetmanagement.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;
    @GetMapping("")
    public List<IncomeEntity> getAllIncome(){
        return incomeService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<IncomeEntity> getIncome( @PathVariable Long id){
        return incomeService.findOne(id);
    }
    @PostMapping("")
    public IncomeEntity saveIncome(@RequestBody IncomeDto income){
        return incomeService.saveIncome(income);
    }
    @PutMapping("/{id}")
    public IncomeEntity saveIncome(@PathVariable Long id, @RequestBody IncomeDto income){
        return incomeService.updateIncome(id,income);
    }
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id){
        incomeService.deleteIncome(id);
    }
}
