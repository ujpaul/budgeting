package com.budgeting.burdgetmanagement.controller;

import com.budgeting.burdgetmanagement.LoginDto;
import com.budgeting.burdgetmanagement.dto.ResponseDto;
import com.budgeting.burdgetmanagement.service.JwtLoginService;
import com.budgeting.burdgetmanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {
    private final JwtLoginService jwtLoginService;
    private final UserService userService;

    public UserController(JwtLoginService jwtLoginService, UserService userService) {
        this.jwtLoginService = jwtLoginService;
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseDto register(@RequestBody LoginDto loginDto){
        userService.saveUser(loginDto);
        return new ResponseDto(200,"User registered successfully");
    }
    @PostMapping("/login")
    @ResponseBody
    public ResponseDto login(@RequestBody LoginDto loginDto, HttpServletRequest request) throws Exception {

        ResponseDto response =jwtLoginService.login(loginDto);
        return response;
    }
}
