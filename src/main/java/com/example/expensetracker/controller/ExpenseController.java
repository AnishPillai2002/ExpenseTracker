package com.example.expensetracker.controller;



import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

//MVC Controller that will handle http request
@Controller
public class ExpenseController {

    //Dependency Injection
    @Autowired
    private ExpenseService expenseService;

    //Home Page Rout Get Request
    @GetMapping("/")
    public String viewHomePage(Model model){

        //List of all expenses in database
        List<Expense> expenses = expenseService.getAllExpenses();

        //Calculating total expense
        BigDecimal totalAmount=expenses.stream().map(Expense::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);

        //Adding expenses and totalAmount to model
        model.addAttribute("expenses",expenses);
        model.addAttribute("totalAmount",totalAmount);

        //Returning index.html
        return "index";
    }
}
