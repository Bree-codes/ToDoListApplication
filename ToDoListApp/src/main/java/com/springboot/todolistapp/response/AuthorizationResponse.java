package com.springboot.todolistapp.response;

import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorizationResponse {

    private Long id;

    private HttpStatus status;

    private String message;

    private String jwt;

    private String username;
}
