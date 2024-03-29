package com.springboot.todolistapp.CustomExceptions;

public class DateConversionException extends RuntimeException {
    public DateConversionException(String message) {
        super(message);
    }
}
