package com.springboot.todolistapp.controller;

import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.RegistrationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class RegistrationController {

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody RegistrationRequest registrationRequest){
        log.info("Register Request" + registrationRequest);

        String username = registrationRequest.getUsername();
        String responseMessage = "User " + username + " created successfully";

        RegistrationResponse response = new RegistrationResponse("success",responseMessage);

        return ResponseEntity.ok(response);
    }



}
