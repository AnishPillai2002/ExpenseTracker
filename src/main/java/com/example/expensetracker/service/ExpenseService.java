package com.example.expensetracker.service;


import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service class contains business logic, Spring will automatically detect it and register as
// a bean
@Service
public class ExpenseService {

    //Dependency Injection using @Autowired
    @Autowired
    private ExpenseRepository expenseRepository;
}
