package com.springboot.todolistapp.response;

import lombok.Data;

@Data
public class RegistrationResponse {

    private String status;
    private String message;

    public RegistrationResponse() {
    }
    public RegistrationResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
