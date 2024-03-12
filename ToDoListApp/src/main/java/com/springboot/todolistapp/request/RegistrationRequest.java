package com.springboot.todolistapp.request;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String email;
    private String username;
    private String password;

    public RegistrationRequest() {
    }
    public RegistrationRequest(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
