package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.entity.AccountEntity;
import com.budgeting.burdgetmanagement.entity.UserEntity;
import com.budgeting.burdgetmanagement.repository.AccountRepository;
import com.budgeting.burdgetmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    private UserRepository userRepository;
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public List<AccountEntity> getAllAccounts() {
        Long userId = (Long) request.getAttribute("userId");
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return accountRepository.findAllByUser(user);
    }
    public Optional<AccountEntity> getSingleAccount(Long id){
        return accountRepository.findById(id);
    }
    public void saveAccount(AccountEntity account){
        Long userId = (Long) request.getAttribute("userId");
        UserEntity user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Account not found"));
        account.setCreatedAt(LocalDateTime.now());
        account.setUser(user);
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
