package com.example.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Starting point of the Application


//@SpringBootApplication annotation can be used to enable three features, that is:
//@EnableAutoConfiguration: automatically configure your Spring application based on the jar dependencies that you have added.
//@Configuration: allow to register extra beans in the context or import additional configuration classes
@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}
}
//Dependency Injection
/*
 Dependency Injection lets a system like Spring Boot manage the
 connections between different parts of your code,
 making development smoother and more streamlined,
 just like having car experts build your vehicle.
 */

//Bean: the different components of the application is called a bean.