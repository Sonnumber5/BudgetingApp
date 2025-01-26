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

    @Autowired
    private IncomesBusinessService incomesBusinessService;

    @GetMapping("/incomes")
    public String showIncomes(Model model) {
        List<IncomeModel> incomes = incomesBusinessService.getIncomes();
        
        model.addAttribute("title", "My Income");
        model.addAttribute("incomes", incomes);

        return "incomes"; 
    }
    
    @PostMapping("/addIncome")
    public String addIncome(@RequestParam String description, @RequestParam double amount) {
    	incomesBusinessService.addIncome(description, amount);
        return "redirect:/incomes";
    }
}
