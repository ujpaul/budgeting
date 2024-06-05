package com.budgeting.burdgetmanagement.controller;

import com.budgeting.burdgetmanagement.entity.AccountEntity;
import com.budgeting.burdgetmanagement.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts")
@CrossOrigin
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    public List<AccountEntity> allAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/{id}")
    public Optional<AccountEntity> singleAccount(@PathVariable Long id){
        return accountService.getSingleAccount(id);
    }
    @PostMapping("")
    public void saveAccount(@RequestBody AccountEntity account){
        accountService.saveAccount(account);
    }
    @PutMapping("/{id}")
    public AccountEntity updateAccount(@PathVariable Long id, @RequestBody AccountEntity account){
        return accountService.updateAccount(id,account);
    }
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
}
