package com.jessefranklin.example.expensemanagement.exception;

import lombok.Data;

@Data
public class ExpenseException extends RuntimeException {
    private String message;
    public ExpenseException(String message) {
        this.message = message;
    }
}
