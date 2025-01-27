package com.gcu.controller;

import com.gcu.business.IncomesBusinessService;
import com.gcu.model.IncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IncomeController {

	//autowire the main income business logic to this class
    @Autowired
    private IncomesBusinessService incomesBusinessService;

    //receives a POST request, grabs all the incomes items from the business layer, returns them to the  thymeleaf template, and returns the incomes.html view
    @GetMapping("/incomes")
    public String showIncomes(Model model) {
        List<IncomeModel> incomes = incomesBusinessService.getIncomes();
        
        model.addAttribute("title", "My Income");
        model.addAttribute("incomes", incomes);

        return "incomes"; 
    }
    
    //receives a GET request, receives input from a form, creates an new instance of IncomeModel, and adds that item to the business layer, then redirected to the incomes.html view 
    @PostMapping("/addIncome")
    public String addIncome(@RequestParam String description, @RequestParam double amount) {
    	incomesBusinessService.addIncome(description, amount);
        return "redirect:/incomes";
    }
}
