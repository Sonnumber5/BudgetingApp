package com.gcu.controller;

import com.gcu.business.IncomesBusinessInterface;
import com.gcu.data.IncomeDataService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class IncomeController {

    @Autowired 
    private IncomesBusinessInterface incomesBusinessInterface;
    
    @Autowired
    private IncomeRepository incomeRepository;
     
    
    @Autowired
    private IncomeDataService dataService;

    @GetMapping("/incomes")
    public String showIncomes(Model model) {
        List<IncomeEntity> unsortedIncomes = incomeRepository.findAll();
        List<IncomeEntity> incomesSortedByDate = incomesBusinessInterface.descByDate(unsortedIncomes);
        
        model.addAttribute("title", "My Income");
        model.addAttribute("incomesSortedByDate", incomesSortedByDate);

        return "incomes"; 
    }
    
    @PostMapping("/addIncome")
    public String addIncome(@ModelAttribute IncomeModel income, Model model) {
    	incomesBusinessInterface.addIncome(income.getDescription(), income.getAmount(), income.getDate(), income.getNotes());
        return "redirect:/incomes";
    }
    
    @PostMapping("/deleteIncome")
    public String deleteIncome(Model model, @RequestParam("incomeId") int id, RedirectAttributes redirectAttributes) { 
        	dataService.delete(id);
        
        List<IncomeEntity> incomes = dataService.findAll();
        model.addAttribute("incomes", incomes);
        return "/incomes";
    }
}