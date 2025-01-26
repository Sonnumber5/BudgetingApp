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
@RequestMapping("/service")
public class IncomesRestService {

    @Autowired
    private IncomesBusinessInterface service;

    @GetMapping(path = "/getjson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<IncomeModel> getOrdersAsJson() {
        return service.getIncomes();
    }

    @GetMapping(path = "/getxml", produces = {MediaType.APPLICATION_XML_VALUE})
    public IncomeList getOrdersAsXml() {
        IncomeList list = new IncomeList();
        list.setIncomes(service.getIncomes());
        return list;
    }
}
