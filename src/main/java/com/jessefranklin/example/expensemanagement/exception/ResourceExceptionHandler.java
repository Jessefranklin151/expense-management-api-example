package com.jessefranklin.example.expensemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ExpenseException.class)
    public ResponseEntity<StandardError> objectNotFound(ExpenseException e, HttpServletRequest request) {
        StandardError err = new StandardError(
                System.currentTimeMillis(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
