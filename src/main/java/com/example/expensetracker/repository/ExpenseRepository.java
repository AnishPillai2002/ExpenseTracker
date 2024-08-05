package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA allows us to interact with SQL Databases without using complex codes

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
