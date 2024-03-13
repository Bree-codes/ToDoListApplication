package com.springboot.todolistapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationRequest {

    private String email;

    private String username;

    private String password;

}
