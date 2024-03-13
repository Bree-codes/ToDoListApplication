package com.springboot.todolistapp.controllerAdvice;

import com.springboot.todolistapp.Model.ExceptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLSyntaxErrorException;
import java.util.Date;


@ControllerAdvice
@Slf4j
public class ExceptionHandling {

    {
        log.info("in the controller advice.");
    }

    private final ExceptionModel exceptionModel;

    @Autowired
    public ExceptionHandling(ExceptionModel exceptionModel) {
        this.exceptionModel = exceptionModel;
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<ExceptionModel> handleSQLSyntaxErrorException(SQLSyntaxErrorException error){
        log.error("SQLSyntaxErrorException occurred "  + error.getMessage());

        exceptionModel.setDate(new Date());
        exceptionModel.setMessage("The Value You Entered Is Too Long");
        exceptionModel.setStatus(HttpStatus.BAD_REQUEST);





        return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

}
