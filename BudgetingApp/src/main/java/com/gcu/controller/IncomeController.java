package com.gcu.controller;

import com.gcu.business.IncomeBusinessInterface;
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
	private IncomeBusinessInterface incomeBusinessInterface;

	// -------------- GET ALL INCOMES ---------------//

	@GetMapping("/income/getIncome")
	public String showIncomesView(Model model) {
		List<IncomeModel> incomes = incomeBusinessInterface.descByDate(incomeBusinessInterface.getAllIncomes());

		model.addAttribute("title", "My Income");
		model.addAttribute("incomes", incomes);

		return "incomes";
	}

	// -------------- CREATE INCOME ---------------//

	@PostMapping("/income/addIncome")
	public String addIncome(@ModelAttribute IncomeModel income, Model model) {
		incomeBusinessInterface.addIncome(income.getDescription(), income.getAmount(), income.getDate(),
				income.getNotes());
		return "redirect:/income/getIncome";
	}

	// -------------- DELETE INCOME ---------------//

	@PostMapping("/income/deleteIncome")
	public String deleteIncome(Model model, @RequestParam("incomeId") int id, RedirectAttributes redirectAttributes) {
		incomeBusinessInterface.deleteIncome(id);

		return "redirect:/income/getIncome";
	}

	// -------------- UPDATE INCOME ---------------//

	@PostMapping("/income/updateIncome")
	public String showUpdateIncomeView(@RequestParam("incomeId") int id, Model model) {
		IncomeModel incomeToUpdate = incomeBusinessInterface.findIncomeById(id);
		model.addAttribute("incomeToUpdate", incomeToUpdate);
		return "income-update";
	}

	@PostMapping("/income/updateIncome/confirm")
	public String confirmUpdateIncome(@RequestParam("incomeId") int id, @RequestParam String description,
			@RequestParam double amount, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam String notes, Model model) {
		IncomeModel incomeToUpdate = incomeBusinessInterface.findIncomeById(id);

		incomeToUpdate.setDescription(description);
		incomeToUpdate.setAmount(amount);
		incomeToUpdate.setDate(date);
		incomeToUpdate.setNotes(notes);

		incomeBusinessInterface.updateIncome(incomeToUpdate);

		return "redirect:/income/getIncome";
	}
}