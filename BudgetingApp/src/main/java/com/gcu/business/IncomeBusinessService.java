package com.gcu.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.IncomeDataService;
import com.gcu.data.entities.IncomeEntity;
import com.gcu.model.IncomeModel;

//main business logic for the income 
public class IncomeBusinessService implements IncomeBusinessInterface {

	@Autowired
	private IncomeDataService incomeDataService;

	// ------------------- ADD INCOME ------------------- //

	@Override
	public void addIncome(String description, double amount, Date date, String notes) {
		IncomeEntity income = new IncomeEntity(description, amount, date, notes);
		try {
			incomeDataService.create(income);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------- ORGANIZE ------------------- //

	@Override
	public double calculateTotalIncomes() {
		List<IncomeEntity> incomes = incomeDataService.findAll();
		double total = 0.00;
		for (IncomeEntity income : incomes) {
			total += income.getAmount();
		}
		return total;
	}

	@Override
	public List<IncomeModel> descByDate(List<IncomeModel> incomes) {
		return incomes.stream().sorted(Comparator.comparing(IncomeModel::getDate).reversed()).toList();
	}
	
	@Override
	public List<IncomeModel> getIncomeByDate(String filterDate) {
		List<IncomeModel> allIncomes = this.getAllIncomes();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

	    List<IncomeModel> incomesFilteredByDate = allIncomes.stream().filter(income -> sdf.format(income.getDate()).equals(filterDate)).collect(Collectors.toList());
	    
	    return descByDate(incomesFilteredByDate);
	}
	
	@Override
	public double CalculateIncomesByDate(String filterDate) {
		List<IncomeModel> allIncomes = this.getAllIncomes();
		double total = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		List<IncomeModel> incomesFilteredByDate = allIncomes.stream().filter(income -> sdf.format(income.getDate()).equals(filterDate)).collect(Collectors.toList());
		
		for (IncomeModel income : incomesFilteredByDate) {
			total += income.getAmount();
		}
		return total;
	}

	// ------------------- FIND ------------------- //

	@Override
	public List<IncomeModel> getAllIncomes() {
		List<IncomeEntity> incomeEntities = incomeDataService.findAll();
		List<IncomeModel> incomes = new ArrayList<>();

		for (IncomeEntity entity : incomeEntities) {
			incomes.add(new IncomeModel(entity.getId(), entity.getDescription(), entity.getAmount(), entity.getDate(),
					entity.getNotes()));
		}
		return incomes;
	}

	@Override
	public IncomeModel findIncomeById(int id) {
		IncomeEntity incomeEntity = incomeDataService.findById(id);
		return new IncomeModel(incomeEntity.getId(), incomeEntity.getDescription(), incomeEntity.getAmount(),
				incomeEntity.getDate(), incomeEntity.getNotes());
	}

	// ------------------- UPDATE ------------------- //

	@Override
	public void updateIncome(IncomeModel incomeToUpdate) {
		IncomeEntity incomeEntity = incomeDataService.findById(incomeToUpdate.getId());

		incomeEntity.setDescription(incomeToUpdate.getDescription());
		incomeEntity.setAmount(incomeToUpdate.getAmount());
		incomeEntity.setDate(incomeToUpdate.getDate());
		incomeEntity.setNotes(incomeToUpdate.getNotes());

		incomeDataService.update(incomeEntity);
	}

	// ------------------- DELETE ------------------- //

	@Override
	public void deleteIncome(int id) {
		incomeDataService.delete(id);
	}

	// ------------------- LIFECYCLE METHODS ------------------- //

	@Override
	public void init() {
		System.out.println("IncomesBusinessService init method call");
	}

	@Override
	public void destroy() {
		System.out.println("IncomesBusinessService destroy method call");
	}
}
