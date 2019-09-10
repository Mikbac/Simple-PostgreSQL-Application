package com.spring.controllers;

import com.spring.services.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by MikBac on 29.05.2019
 */

@Controller
public class ExampleTableController {

    private ExampleTableService exampleTableService;

    @Autowired
    public ExampleTableController(ExampleTableService exampleTableService) {
        this.exampleTableService = exampleTableService;
    }

    @GetMapping(value = "/table")
    public String home(final Model model) {
        model.addAttribute("tables", exampleTableService.findAll());
        model.addAttribute("uniqueTable1", exampleTableService.getUniqueTables("kolumna1"));
        model.addAttribute("uniqueTable2", exampleTableService.getUniqueTables("kolumna2"));
        model.addAttribute("uniqueTable3", exampleTableService.getUniqueTables("kolumna3"));
        model.addAttribute("uniqueTable4", exampleTableService.getUniqueTables("kolumna4"));
        model.addAttribute("repeatedTable1", exampleTableService.getRepeatedTables("kolumna1"));
        model.addAttribute("repeatedTable2", exampleTableService.getRepeatedTables("kolumna2"));
        model.addAttribute("repeatedTable3", exampleTableService.getRepeatedTables("kolumna3"));
        model.addAttribute("repeatedTable4", exampleTableService.getRepeatedTables("kolumna4"));
        return "table";
    }

}
