package com.example.expensetracker.controller;



import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

//MVC Controller that will handle http request
@Controller
public class ExpenseController {

    //Dependency Injection
    @Autowired
    private ExpenseService expenseService;

    //Home Page Get Request
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

    //Add Expense Page Get Request
    @GetMapping("/addExpense")
    public String showAddExpensePage(Model model){

        //Creating new Expense Object
        Expense expense=new Expense();

        //Adding it to model
        model.addAttribute("expense",expense);

        //Returning add expense page
        return "add-expense";
    }

    //Add Expense Post Request
    @PostMapping("/saveExpense")
    public String saveExpense(@ModelAttribute("expense") Expense expense,Model model){
        expenseService.saveExpense(expense);
        return "redirect:/";
    }

    //Edit Expense Page Get Request
    @GetMapping("editExpense/{id}")
    public String showUpdateExpensePage(@PathVariable("id") long id,Model model){
        Expense expense=expenseService.getExpenseId(id);
        model.addAttribute("expense",expense);
        return "update-expense";

    }

    //Edit Expense Post Request
    @PostMapping("/updateExpense/{id}")
    public String updateExpense(@PathVariable("id") long id,@ModelAttribute("expense") Expense expense){
        Expense existingExpense=expenseService.getExpenseId(id);

        //updating
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());

        //saving new expense
        expenseService.saveExpense(existingExpense);

        return "redirect:/";
    }

    //Delete Expense Get Request
    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable("id") long id){
        expenseService.deleteExpenseById(id);
        return "redirect:/";
    }

}
