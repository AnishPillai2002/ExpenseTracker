package com.example.expensetracker.service;


import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service class contains business logic, Spring will automatically detect it and register as
// a bean
@Service
public class ExpenseService {

    //Dependency Injection using @Autowired
    @Autowired
    private ExpenseRepository expenseRepository;


    //Function to get all expenses
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    //Function to save expense to database
    public void saveExpense(Expense expense){
        expenseRepository.save(expense);
        //If the expense already exist in database, then it will be updated
    }

    //Function to get expense by id
    public Expense getExpenseId(Long id){
        return expenseRepository.findById(id).orElse(null);
        //it returns null if we cant find a an Expense with the given id in the database
    }

    //Function to delete the expense
    public void deleteExpenseById(Long id){
        expenseRepository.deleteById(id);
    }
}
