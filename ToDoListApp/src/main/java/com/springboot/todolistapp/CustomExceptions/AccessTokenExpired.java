package com.springboot.todolistapp.CustomExceptions;

public class AccessTokenExpired extends RuntimeException{
    public AccessTokenExpired(String message) {
        super(message);
    }
}
