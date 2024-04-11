package com.springboot.todolistapp.CustomExceptions;

public class ExpiredCookieException extends RuntimeException{
    public ExpiredCookieException(String message) {
        super(message);
    }
}
