package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.LoginDto;
import com.budgeting.burdgetmanagement.dto.ResponseDto;
import com.budgeting.burdgetmanagement.entity.UserEntity;
import com.budgeting.burdgetmanagement.exception.InvalidCredentialsException;
import com.budgeting.burdgetmanagement.repository.UserRepository;
import com.budgeting.burdgetmanagement.utilities.GeneralLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;


@Service
public class JwtLoginService {
    private final PasswordService passwordService;
    private static Logger logger = LoggerFactory.getLogger(GeneralLogger.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserRepository userRepository;

    private String userName;
    private String password;
    private UserEntity user;

    public JwtLoginService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    public ResponseDto login(LoginDto request) {
        ResponseDto responseDto = new ResponseDto();

        if (request.getUsername() != null && request.getPassword() != null &&
                request.getUsername().length() > 0 &&
                request.getPassword().length() > 0) {

            userName = request.getUsername();
            password = request.getPassword();

            boolean isCorrectCredentials = isUserAllowed(userName, password);

            Optional<UserEntity> optionalUsers = userRepository.findByUserName(userName);
            if(optionalUsers.isPresent()){
                 user = optionalUsers.get();
            }
            if (isCorrectCredentials) {
                String token = jwtProvider.createJwtToken(userName);
                responseDto = new ResponseDto("Login successfully",jwtProvider.getExpiryDate(token), 200, token, userName);
            } else {
                responseDto = new ResponseDto(
                        "Invalid username or password",
                        null,
                        400,
                        null,
                        null
                );
            }
        } else {
            throw new InvalidCredentialsException("Invalid username or password.");
        }

        return responseDto;
    }

    /**
     * @param username
    //     * @param password
     * @return
     */



    public Boolean isUserAllowed(String username, String password) {
        Optional<UserEntity> userToLogin = userRepository.findByUserName(username);
        System.out.println("Hashed Password: " + userToLogin.get().getPassword() + "Plain password: " + password);

        if (userToLogin.isPresent() && passwordService.checkPassword(password,userToLogin.get().getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param encodedPasswd
     * @return
     */
    public String decodePasswd(String encodedPasswd) {
        Base64.Decoder decoder = Base64.getDecoder();
        String decodedPassword = new String(decoder.decode(encodedPasswd));
        return decodedPassword;
    }

    /**
     * @param passwordToEncode
     * @return
     */
    public String encodePasswd(String passwordToEncode) {
        Base64.Encoder encoder = Base64.getEncoder();
        return new String(encoder.encode(passwordToEncode.getBytes()));
    }

    public String getStackString(Exception ex) {
        String errorStackTrace = "";
        StackTraceElement[] stack = ex.getStackTrace();

        for (int i = 0; i < stack.length; i++) {
            if (errorStackTrace.length() == 0)
                errorStackTrace = errorStackTrace + stack[i].toString();
            else
                errorStackTrace = errorStackTrace + "|" + stack[i].toString();
        }

        return errorStackTrace;
    }

}
