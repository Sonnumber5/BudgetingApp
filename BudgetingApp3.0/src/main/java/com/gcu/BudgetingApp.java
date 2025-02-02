package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.gcu" })
public class BudgetingApp {

	public static void main(String[] args) {
		SpringApplication.run(BudgetingApp.class, args);
	}
}
