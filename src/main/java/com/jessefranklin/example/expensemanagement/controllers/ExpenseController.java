package com.jessefranklin.example.expensemanagement.controllers;

import com.jessefranklin.example.expensemanagement.dto.CreateExpenseDTO;
import com.jessefranklin.example.expensemanagement.dto.ExpenseDTO;
import com.jessefranklin.example.expensemanagement.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    private ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ExpenseDTO> createExpense(@RequestBody CreateExpenseDTO createExpenseDTO) {
        return new ResponseEntity<>(expenseService.createExpense(createExpenseDTO), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    private ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long id) {
        return new ResponseEntity<>(expenseService.getExpenseById(id), HttpStatus.OK);
    }

}
