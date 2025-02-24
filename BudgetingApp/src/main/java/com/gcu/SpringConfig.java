package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.ExpenseBusinessService;
import com.gcu.business.FundsBusinessService;
import com.gcu.business.IncomeBusinessService;

//Tells spring this class is a configuration class
@Configuration
public class SpringConfig {

    // this method is used to create an object that will be managed as a bean by Spring.
    @Bean(name="incomesBusinessService", initMethod="init", destroyMethod="destroy")
    public IncomeBusinessService getIncomesBusiness() {
        return new IncomeBusinessService();
    }

    // this method is used to create an object that will be managed as a bean by Spring.
    @Bean(name="expensesBusinessService", initMethod="init", destroyMethod="destroy")
    public ExpenseBusinessService getExpensesBusiness() {
        return new ExpenseBusinessService();
    }
    
 // this method is used to create an object that will be managed as a bean by Spring.
    @Bean(name="fundsBusinessService", initMethod="init", destroyMethod="destroy")
    public FundsBusinessService getFundsBusiness() {
        return new FundsBusinessService();
    }
}
