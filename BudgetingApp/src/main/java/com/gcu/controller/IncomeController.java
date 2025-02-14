package com.gcu.controller;

import com.gcu.business.IncomesBusinessInterface;
import com.gcu.data.IncomeDataService;
import com.gcu.data.entities.IncomeEntity;
import com.gcu.model.IncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
public class IncomeController {

    @Autowired 
    private IncomesBusinessInterface incomesBusinessInterface;
    
    @Autowired
    private IncomeDataService dataService;

    @GetMapping("/incomes")
    public String showIncomesView(Model model) {
        List<IncomeEntity> incomes = incomesBusinessInterface.descByDate();
        
        model.addAttribute("title", "My Income");
        model.addAttribute("incomes", incomes);

        return "incomes"; 
    }
    
    @PostMapping("/income/add")
    public String addIncome(@ModelAttribute IncomeModel income, Model model) {
    	incomesBusinessInterface.addIncome(income.getDescription(), income.getAmount(), income.getDate(), income.getNotes());
        return "redirect:/incomes";
    }
    
    @PostMapping("/income/delete")
    public String deleteIncome(Model model, @RequestParam("incomeId") int id, RedirectAttributes redirectAttributes) { 
        	dataService.delete(id);

        return "redirect:/incomes";
    }
    
    @PostMapping("/income/update")
    public String showUpdateIncomeView(@RequestParam ("incomeId") int id, Model model) {
    	IncomeEntity incomeToUpdate = dataService.findById(id);
    	model.addAttribute("incomeToUpdate", incomeToUpdate);
    	return "income-update";
    }
    
    @PostMapping("/income/update/confirm")
    public String confirmUpdateIncome(@RequestParam ("incomeId") int id, @RequestParam String description,  @RequestParam double amount, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam String notes, Model model) {
    	IncomeEntity income = dataService.findById(id);

    		income.setDescription(description);
    		income.setAmount(amount);
    		income.setDate(date);
    		income.setNotes(notes);
    	
    	dataService.update(income);
    	
    	
    	return "redirect:/incomes";
    }
}