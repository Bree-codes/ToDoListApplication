package com.springboot.todolistapp.controller;

import com.springboot.todolistapp.request.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest){

        return null;
    }



}
