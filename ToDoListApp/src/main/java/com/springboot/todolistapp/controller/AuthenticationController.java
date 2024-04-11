package com.springboot.todolistapp.controller;

import com.springboot.todolistapp.request.LoginRequest;
import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.AuthorizationResponse;
import com.springboot.todolistapp.response.RefreshResponseModel;
import com.springboot.todolistapp.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
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
    public ResponseEntity<AuthorizationResponse> registerUser(
            @RequestBody RegistrationRequest registrationRequest, HttpServletResponse response){
        log.info("Registration Request");
        return authenticationService.registerUser(registrationRequest, response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> login(
            @RequestBody LoginRequest loginRequest, HttpServletResponse response){
        return ResponseEntity.ok(authenticationService.authenticate(loginRequest , response));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshResponseModel> refreshToken(HttpServletResponse response, HttpServletRequest request){
        return authenticationService.refresh(request, response);
    }

}
