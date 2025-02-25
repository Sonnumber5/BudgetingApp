package com.gcu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gcu.business.ExpenseBusinessInterface;
import com.gcu.model.ExpenseModel;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("categories")
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseBusinessInterface expenseBusinessInterface;

	// -------------- Get All Expenses ---------------//

	@GetMapping("/getExpenses")
	public String showExpensesView(Model model) {
		List<ExpenseModel> totalExpenses = expenseBusinessInterface
				.descByDate(expenseBusinessInterface.getAllExpenses());
		List<List<ExpenseModel>> categories = expenseBusinessInterface.categorizeExpenses(totalExpenses);

		model.addAttribute("title", "My Expenses");
		model.addAttribute("categories", categories);

		return "expenses";
	}

	// -------------- Create Expense ---------------//

	@PostMapping("/createExpense")
	public String addExpense(@ModelAttribute ExpenseModel expense, Model model,
			@RequestParam(required = false) String newCategory) {
		if (newCategory != null && !newCategory.isEmpty()) {
			expense.setCategory(newCategory);
		}
		if (expense.getCategory() == null) {
			expense.setCategory("Default Category");
		}
		expenseBusinessInterface.addExpense(expense.getDescription(), expense.getAmount(), expense.getCategory(),
				expense.getDate(), expense.getNotes());

		return "redirect:/expenses/getExpenses";
	}

	// -------------- Delete Expense ---------------//

	@PostMapping("/deleteExpense")
	public String deleteExpense(Model model, @RequestParam("expenseId") int id) {
		expenseBusinessInterface.deleteExpense(id);
		List<ExpenseModel> expenses = expenseBusinessInterface.getAllExpenses();

		model.addAttribute("expenses", expenses);
		return "redirect:/expenses/getExpenses";
	}

	// -------------- Update Expense ---------------//

	@PostMapping("/updateExpense")
	public String showExpenseUpdateView(@RequestParam("expenseId") int id, Model model, HttpSession session) {
		ExpenseModel expenseToUpdate = expenseBusinessInterface.findExpenseById(id);

		List<ExpenseModel> totalExpenses = expenseBusinessInterface
				.descByDate(expenseBusinessInterface.getAllExpenses());
		List<List<ExpenseModel>> categories = expenseBusinessInterface.categorizeExpenses(totalExpenses);

		model.addAttribute("title", "Update Expense");
		model.addAttribute("expenseToUpdate", expenseToUpdate);
		model.addAttribute("categories", categories);
		return "expense-update";
	}

	@PostMapping("/updateExpense/confirm")
	public String confirmUpdateExpense(@RequestParam("expenseId") int id, @RequestParam String description,
			@RequestParam double amount, @RequestParam String category, @RequestParam String newCategory,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam String notes) {
		ExpenseModel expenseToUpdate = expenseBusinessInterface.findExpenseById(id);
		if (newCategory != null && newCategory != "") {
			category = newCategory;
		}

		expenseToUpdate.setDescription(description);
		expenseToUpdate.setAmount(amount);
		if (category != null && newCategory != null) {
			expenseToUpdate.setCategory(category);
		}
		expenseToUpdate.setDate(date);
		expenseToUpdate.setNotes(notes);

		expenseBusinessInterface.updateExpense(expenseToUpdate);

		return "redirect:/expenses/getExpenses";
	}
}
