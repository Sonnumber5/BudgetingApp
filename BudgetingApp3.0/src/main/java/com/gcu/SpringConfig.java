package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.ExpensesBusinessService;
import com.gcu.business.IncomesBusinessService;

//Tells spring this class is a configuration class
@Configuration
public class SpringConfig {

    // this method is used to create an object that will be managed as a bean by Spring.
    @Bean(name="incomesBusinessService", initMethod="init", destroyMethod="destroy")
    public IncomesBusinessService getIncomesBusiness() {
        return new IncomesBusinessService();
    }

    // this method is used to create an object that will be managed as a bean by Spring.
    @Bean(name="expensesBusinessService", initMethod="init", destroyMethod="destroy")
    public ExpensesBusinessService getExpensesBusiness() {
        return new ExpensesBusinessService();
    }
}
