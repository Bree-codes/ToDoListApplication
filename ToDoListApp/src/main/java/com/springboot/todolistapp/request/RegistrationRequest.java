package com.springboot.todolistapp.request;

import com.springboot.todolistapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationRequest {

    private String username;

    private String email;

    private String password;

}
