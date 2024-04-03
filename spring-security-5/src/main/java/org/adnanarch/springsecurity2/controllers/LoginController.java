package org.adnanarch.springsecurity2.controllers;

import org.adnanarch.springsecurity2.dto.CustomerDto;
import org.adnanarch.springsecurity2.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerDto customerDto) {
        try {
            boolean isCreated = loginService.createUser(customerDto);
            if (isCreated) {
                return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Register User.");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Exception Occurred: " + ex.getMessage());
        }
    }
}
