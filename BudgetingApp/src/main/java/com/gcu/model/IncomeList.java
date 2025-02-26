package com.gcu.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

//root element for XML serialization and deserialization 
@XmlRootElement(name = "incomes")
public class IncomeList {

	// a list that holds IncomeModel objects 
    private List<IncomeModel> incomes = new ArrayList<>();

    //binds this method to the income element in XML
    @XmlElement(name = "income") 
    public List<IncomeModel> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<IncomeModel> incomes) {
        this.incomes = incomes;
    }
}
