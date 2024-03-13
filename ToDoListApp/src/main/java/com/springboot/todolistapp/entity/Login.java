package com.springboot.todolistapp.entity;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class Login {

    private String username;
    private String password;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
