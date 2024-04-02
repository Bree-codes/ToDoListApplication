package com.springboot.todolistapp.controller;

import com.springboot.todolistapp.request.LoginRequest;
import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.AuthorizationResponse;
import com.springboot.todolistapp.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthorizationResponse> registerUser(@RequestBody RegistrationRequest registrationRequest){
        log.info("Registration Request");
        return authenticationService.registerUser(registrationRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authenticationService.authenticate(loginRequest));
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam long id){
        log.warn("login out user.");
        authenticationService.logout(id);
        return new ResponseEntity<>("Log Out Successful", HttpStatus.OK);
    }

}
