package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.FundDataService;
import com.gcu.data.entities.FundEntity;
import com.gcu.data.repositories.FundRepository;

//main business logic for the income 
public class FundsBusinessService implements FundsBusinessInterface {
	
	@Autowired
	private FundRepository fundRepository;
	
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
	
	@Override
    public void addFund(String name, double goal, double amount, String notes) {
        FundEntity fund = new FundEntity(name, goal, amount, notes);
        try {
        	fundsDataService.create(fund);
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
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
