package com.jessefranklin.example.expensemanagement.repositories;

import com.jessefranklin.example.expensemanagement.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
