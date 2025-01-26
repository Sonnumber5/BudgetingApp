package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.ExpensesBusinessService;
import com.gcu.business.IncomesBusinessInterface;
import com.gcu.business.IncomesBusinessService;

@Configuration
public class SpringConfig {

    @Bean(name="incomesBusinessService", initMethod="init", destroyMethod="destroy")
    public IncomesBusinessInterface getIncomesBusiness() {
        return new IncomesBusinessService();
    }

    @Bean(name="expensesBusinessService", initMethod="init", destroyMethod="destroy")
    public ExpensesBusinessService getExpensesBusiness() {
        return new ExpensesBusinessService();
    }
}
