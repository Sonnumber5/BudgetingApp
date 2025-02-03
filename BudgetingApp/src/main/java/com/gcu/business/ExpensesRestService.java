package com.gcu.business;

import com.gcu.model.ExpenseList;
import com.gcu.model.ExpenseModel;
import com.gcu.model.IncomeList;
import com.gcu.model.IncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/expenseservice")
public class ExpensesRestService {

	//autowires the ExpensesbusinessInterface to this class
    @Autowired
    private ExpensesBusinessInterface service;

    // displays all expense items as JSON
    @GetMapping(path = "/getexpensejson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ExpenseModel> getExpensesAsJson() {
        return service.getExpenses();
    }

    // displays all expense items as XML
    @GetMapping(path = "/getexpensexml", produces = {MediaType.APPLICATION_XML_VALUE})
    public ExpenseList getExpensesAsXml() {
        ExpenseList list = new ExpenseList();
        list.setExpenses(service.getExpenses());
        return list;
    }
}
