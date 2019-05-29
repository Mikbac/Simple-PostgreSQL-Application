package com.controllers;

import com.services.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleTableController {

    private ExampleTableService exampleTableService;


    @Autowired
    public ExampleTableController(ExampleTableService exampleTableService) {
        this.exampleTableService = exampleTableService;
    }

    @GetMapping(value = "/table")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("tables", exampleTableService.findAll());

        modelAndView.addObject("uniqueTable1", exampleTableService.getUniqueTables("kolumna1"));

        modelAndView.addObject("uniqueTable2", exampleTableService.getUniqueTables("kolumna2"));

        modelAndView.addObject("uniqueTable3", exampleTableService.getUniqueTables("kolumna3"));

        modelAndView.addObject("uniqueTable4", exampleTableService.getUniqueTables("kolumna4"));

        modelAndView.addObject("repeatedTable1", exampleTableService.getRepeatedTables("kolumna1"));

        modelAndView.addObject("repeatedTable2", exampleTableService.getRepeatedTables("kolumna2"));

        modelAndView.addObject("repeatedTable3", exampleTableService.getRepeatedTables("kolumna3"));

        modelAndView.addObject("repeatedTable4", exampleTableService.getRepeatedTables("kolumna4"));

        return modelAndView;
    }


}
