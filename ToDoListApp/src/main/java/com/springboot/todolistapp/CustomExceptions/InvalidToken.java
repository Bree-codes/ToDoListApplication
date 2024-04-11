package com.springboot.todolistapp.CustomExceptions;

public class InvalidToken extends RuntimeException{
    public InvalidToken(String message) {
        super(message);
    }
}
