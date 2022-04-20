package com.jessefranklin.example.expensemanagement.exception;

public class ExpenseNotFoundException extends ExpenseException {
    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
