package com.springboot.todolistapp.controller;

import com.springboot.todolistapp.request.LoginRequest;
import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.AuthorizationResponse;
import com.springboot.todolistapp.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthorizationResponse> registerUser(@RequestBody RegistrationRequest registrationRequest){
        log.info("Registration Request");

        return  registrationService.registerUser(registrationRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> login(@RequestBody LoginRequest loginRequest){

        return null;

    }

}
