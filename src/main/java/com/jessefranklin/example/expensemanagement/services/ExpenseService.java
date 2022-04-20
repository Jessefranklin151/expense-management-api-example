package com.jessefranklin.example.expensemanagement.services;


import com.jessefranklin.example.expensemanagement.dto.CreateExpenseDTO;
import com.jessefranklin.example.expensemanagement.dto.ExpenseDTO;
import com.jessefranklin.example.expensemanagement.exception.ExpenseNotFoundException;
import com.jessefranklin.example.expensemanagement.models.Expense;
import com.jessefranklin.example.expensemanagement.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(ExpenseDTO::toDTO)
                .collect(Collectors.toList());
    }

    public ExpenseDTO createExpense(CreateExpenseDTO createExpenseDTO) {
        return ExpenseDTO.toDTO(expenseRepository.save(Expense.toEntity(createExpenseDTO)));
    }

    public ExpenseDTO getExpenseById(Long id) {
        return ExpenseDTO.toDTO(expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException("Expense not found")));
    }
}
