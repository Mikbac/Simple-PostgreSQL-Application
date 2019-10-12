package com.postgres.spring.controller;

import com.postgres.constant.AttributeConstants.ModelAttributes.ExampleTable;
import com.postgres.constant.WebConstants.Mapping;
import com.postgres.spring.facade.ExampleTableFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

import static com.postgres.constant.WebConstants.Views;

/**
 * Created by MikBac on 29.05.2019
 */

@Controller
public class ExampleTableController {

    @Resource
    private ExampleTableFacade exampleTableFacade;

    @GetMapping(value = Mapping.TABLE)
    public String home(final Model model) {
        model.addAttribute(ExampleTable.TABLE, exampleTableFacade.findAll());
        model.addAttribute(ExampleTable.UNIQUE_TABLE_ONE, exampleTableFacade.getUniqueTables("column1"));
        model.addAttribute(ExampleTable.UNIQUE_TABLE_TWO, exampleTableFacade.getUniqueTables("column2"));
        model.addAttribute(ExampleTable.UNIQUE_TABLE_THREE, exampleTableFacade.getUniqueTables("column3"));
        model.addAttribute(ExampleTable.UNIQUE_TABLE_FOUR, exampleTableFacade.getUniqueTables("column4"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_ONE, exampleTableFacade.getRepeatedTables("column1"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_TWO, exampleTableFacade.getRepeatedTables("column2"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_THREE, exampleTableFacade.getRepeatedTables("column3"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_FOUR, exampleTableFacade.getRepeatedTables("column4"));
        return Views.TABLE;
    }

}
