package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.FundsBusinessInterface;
import com.gcu.data.FundDataService;
import com.gcu.data.entities.FundEntity;
import com.gcu.model.FundModel;

import jakarta.servlet.http.HttpSession;

@Controller
public class FundController {

	@Autowired 
    private FundsBusinessInterface fundsBusinessInterface;
    
    @Autowired
    private FundDataService dataService;

    @GetMapping("/funds")
    public String showFundsPage(Model model) {
    	List<FundEntity> funds = dataService.findAll();
    	
        model.addAttribute("title", "My Savings Funds");  
        model.addAttribute("funds", funds);

        return "funds";
    }
    
    @GetMapping("/funds/addFund")
    public String addFundsPage(Model model) {
    	model.addAttribute("title", "Add Savings Funds");
    	return "addFund";
    }
    
    @PostMapping("/funds/contribute")
    public String contributeFund(Model model, @RequestParam("fundId") int id, HttpSession session) {
    	FundEntity fund = dataService.findById(id);
    	session.setAttribute("fund", fund);
    	model.addAttribute("title", "Contribute to Fund");
    	model.addAttribute("fund", fund);
    	return "contributeFund";
    }
    
    @PostMapping("/funds/contribute/confirm")
    public String contributeFundConfirm(Model model, @RequestParam("amount") double amount, HttpSession session) {
    	FundEntity fund = (FundEntity) session.getAttribute("fund");
    	fund.setAmount(fundsBusinessInterface.addAmount(fund.getAmount(), amount));
    	dataService.update(fund);
    	
    	return "redirect:/funds";
    }
    
    @PostMapping("/fund/addfund/confirm")
    public String addFundConfirm(@ModelAttribute FundModel fund, Model model) {
    	String notes = fund.getNotes();
    	if (notes == null || notes.isBlank()) {
    		notes = "";
    	}
    	
    	fundsBusinessInterface.addFund(fund.getName(), fund.getGoal(), 0, notes);
    	return "redirect:/funds";
    }
    
    @PostMapping("/funds/delete")
    public String deleteFund(Model model, @RequestParam("fundId") int id) {
    	dataService.delete(id);
    	return "redirect:/funds";
    }
}

