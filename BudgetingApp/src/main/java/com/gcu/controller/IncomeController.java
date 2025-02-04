package com.gcu.controller;

import com.gcu.business.IncomesBusinessInterface;
import com.gcu.business.IncomesBusinessService;
import com.gcu.data.DataAccessInterface;
import com.gcu.data.entities.IncomeEntity;
import com.gcu.data.repositories.IncomeRepository;
import com.gcu.model.IncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IncomeController {

    @Autowired 
    private IncomesBusinessInterface incomesBusinessInterface;
    
    @Autowired IncomeRepository incomeRepository;

    @GetMapping("/incomes")
    public String showIncomes(Model model) {
        List<IncomeEntity> incomeEntities = incomeRepository.findAll();
        List<IncomeModel> incomes = incomeEntities.stream().map(entity -> new IncomeModel(entity.getDescription(), entity.getAmount(), entity.getDate(), entity.getNotes())).collect(Collectors.toList());
        
        model.addAttribute("title", "My Income");
        model.addAttribute("incomes", incomes);

        return "incomes"; 
    }
    
    @PostMapping("/addIncome")
    public String addIncome(@ModelAttribute IncomeModel income, Model model) {
    	incomesBusinessInterface.addIncome(income.getDescription(), income.getAmount(), income.getDate(), income.getNotes());
        return "redirect:/incomes";
    }
}