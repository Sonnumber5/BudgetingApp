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

    //receives and displays all the IncomeModel objects from the IncomesBusinessService
    @GetMapping("/incomes")
    public String showIncomes(Model model) {
        List<IncomeModel> incomes = incomesBusinessService.getIncomes();
        
        //adds attributes to the model to pass to the view
        model.addAttribute("title", "My Income");
        model.addAttribute("incomes", incomes);

        return "incomes"; 
    }
    
    //receives input from the form that uses action="addIncome" and method="POST", in order to add an instance of IncomeModel through the business service layer. 
    @PostMapping("/addIncome")
    public String addIncome(@RequestParam String description, @RequestParam double amount) {
    	incomesBusinessService.addIncome(description, amount);
        return "redirect:/incomes";
    }
}
