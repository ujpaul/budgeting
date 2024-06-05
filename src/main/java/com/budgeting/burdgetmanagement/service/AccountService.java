package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.entity.AccountEntity;
import com.budgeting.burdgetmanagement.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public List<AccountEntity> getAllAccounts(){
        return accountRepository.findAll();
    }
    public Optional<AccountEntity> getSingleAccount(Long id){
        return accountRepository.findById(id);
    }
    public void saveAccount(AccountEntity account){
        accountRepository.save(account);
    }
    public AccountEntity updateAccount(Long id, AccountEntity account){
        AccountEntity existingAccount = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        existingAccount.setAccountBalance(account.getAccountBalance());
        existingAccount.setAccountName(account.getAccountName());
        existingAccount.setAccountInitialBalance(account.getAccountInitialBalance());
        existingAccount.setAccountType(account.getAccountType());
        return accountRepository.save(existingAccount);
    }
    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
