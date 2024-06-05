package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.LoginDto;
import com.budgeting.burdgetmanagement.entity.UserEntity;
import com.budgeting.burdgetmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public UserService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }
    public UserEntity saveUser(LoginDto loginDto){
        String hashedPassword = passwordService.hashPassword(loginDto.getPassword());
        UserEntity user = new UserEntity();
        user.setUsername(loginDto.getUsername());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

}
