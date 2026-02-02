package com.my.expense_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.expense_backend.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}