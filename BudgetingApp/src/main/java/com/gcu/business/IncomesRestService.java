package com.gcu.business;

import com.gcu.model.IncomeList;
import com.gcu.model.IncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/incomeservice")
public class IncomesRestService {

	//autowires the IncomesBusinessInterface to this class
    @Autowired
    private IncomesBusinessInterface service;

    //display the all income items as JSON
    @GetMapping(path = "/getincomejson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<IncomeModel> getIncomesAsJson() {
        return service.getIncomes();
    }

    //displays all income items at XML
    @GetMapping(path = "/getincomexml", produces = {MediaType.APPLICATION_XML_VALUE})
    public IncomeList getIncomesAsXml() {
        IncomeList list = new IncomeList();
        list.setIncomes(service.getIncomes());
        return list;
    }
}
