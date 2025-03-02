package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.FundDataService;
import com.gcu.data.entities.FundEntity;
import com.gcu.data.repositories.FundRepository;
import com.gcu.model.FundModel;

//main business logic for the income 
public class FundsBusinessService implements FundsBusinessInterface {
	
	@Autowired
	private FundDataService fundsDataService;
	
	@Override
	public void init() {
		System.out.println("FundsBusinessService init method call");
	}
	
	@Override
	public void destroy() {
		System.out.println("FundsBusinessService destroy method call");
	}
	
	// ------------------- CREATE ------------------- //
	
	@Override
    public void addFund(String name, double goal, double amount, String notes) {
        FundEntity fund = new FundEntity(name, goal, amount, notes);
        try {
        	fundsDataService.create(fund);
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
	// ------------------- READ ------------------- //
	
	@Override
	public FundModel findFundById(int id) {
		FundEntity fundEntity = fundsDataService.findById(id);
		return new FundModel(fundEntity.getId(), fundEntity.getName(), fundEntity.getGoal(), fundEntity.getAmount(), fundEntity.getNotes());
	}

	@Override
	public List<FundModel> findAllFunds() {
		List<FundEntity> fundEntities = fundsDataService.findAll();
		List<FundModel> funds = new ArrayList<>();
		for (FundEntity entity : fundEntities) {
			funds.add(new FundModel(entity.getId(), entity.getName(), entity.getGoal(), entity.getAmount(), entity.getNotes()));
		}
		return funds;
	}
	
	// ------------------- DELETE ------------------- //

	@Override
	public void deleteFund(int id) {
		fundsDataService.delete(id);
	}

	// ------------------- UPDATE ------------------- //
	
	@Override
	public void updateFund(FundModel fund) {
		FundEntity fundEntity = fundsDataService.findById(fund.getId());
		
		fundEntity.setName(fund.getName());
		fundEntity.setGoal(fund.getGoal());
		fundEntity.setAmount(fund.getAmount());
		fundEntity.setNotes(fund.getNotes());
		
		fundsDataService.update(fundEntity);	
	}
	
	
	// ------------------- OPERATIONS ------------------- //
	
	
	public double addAmount(double currentAmount, double contribution) {
		return currentAmount + contribution;
	}

	@Override
	public double calculateTotalFunds() {
		List<FundEntity> funds = fundsDataService.findAll();
		double amountSum = 0;
		for (FundEntity fund : funds) {
			amountSum += fund.getAmount();
		}
		
		return amountSum;
	}
}
