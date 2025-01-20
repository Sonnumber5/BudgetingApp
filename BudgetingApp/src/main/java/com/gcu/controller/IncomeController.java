package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.model.IncomeModel;

@Controller
public class IncomeController {
	
	@GetMapping("/income")
	public String showIncomeList(Model model) {
		List<IncomeModel> incomeList = new ArrayList<>();
		
		//temporary income items 
		incomeList.add(new IncomeModel("Salary", 2500.00));
		incomeList.add(new IncomeModel("Freelance", 1500));
		
		model.addAttribute("incomeList", incomeList);
		return "income";
	}
}
