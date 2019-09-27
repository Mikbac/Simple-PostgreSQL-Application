package com.postgres.spring.controllers;

import com.postgres.constants.AttributeConstants.ModelAttributes.ExampleTable;
import com.postgres.constants.WebConstants.Mapping;
import com.postgres.spring.services.ExampleTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

import static com.postgres.constants.WebConstants.Views;

/**
 * Created by MikBac on 29.05.2019
 */

@Controller
public class ExampleTableController {

    @Resource
    private ExampleTableService exampleTableService;

    @GetMapping(value = Mapping.TABLE)
    public String home(final Model model) {
        model.addAttribute(ExampleTable.TABLE, exampleTableService.findAll());
        model.addAttribute(ExampleTable.UNIQUE_TABLE_ONE, exampleTableService.getUniqueTables("column1"));
        model.addAttribute(ExampleTable.UNIQUE_TABLE_TWO, exampleTableService.getUniqueTables("column2"));
        model.addAttribute(ExampleTable.UNIQUE_TABLE_THREE, exampleTableService.getUniqueTables("column3"));
        model.addAttribute(ExampleTable.UNIQUE_TABLE_FOUR, exampleTableService.getUniqueTables("column4"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_ONE, exampleTableService.getRepeatedTables("column1"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_TWO, exampleTableService.getRepeatedTables("column2"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_THREE, exampleTableService.getRepeatedTables("column3"));
        model.addAttribute(ExampleTable.REPEATED_TABLE_FOUR, exampleTableService.getRepeatedTables("column4"));
        return Views.TABLE;
    }

}
