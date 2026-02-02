package com.my.expense_backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.expense_backend.model.Expense;
import com.my.expense_backend.repository.ExpenseRepository;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*") // allow React
public class ExpenseController {

    private final ExpenseRepository repo;

    public ExpenseController(ExpenseRepository repo) {
        this.repo = repo;
    }

    // GET all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    // ADD expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        expense.setDate(LocalDate.now()); // auto current date
        return repo.save(expense);
    }
    
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        repo.deleteById(id);
    }

}