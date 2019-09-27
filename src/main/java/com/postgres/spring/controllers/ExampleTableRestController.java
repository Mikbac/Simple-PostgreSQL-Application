package com.postgres.spring.controllers;

import com.postgres.constants.WebConstants.Mapping;
import com.postgres.model.ExampleTableModel;
import com.postgres.spring.services.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MikBac on 29.05.2019
 */

@CrossOrigin
@RestController
@RequestMapping(Mapping.TABLES)
public class ExampleTableRestController {

    private ExampleTableService exampleTableService;

    @Autowired
    public ExampleTableRestController(ExampleTableService exampleTableService) {
        this.exampleTableService = exampleTableService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTableModel> getAllTables() {
        return exampleTableService.findAll();
    }

    @GetMapping(value = Mapping.UNIQUE_TABLE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTableModel> getUniqueTables(@PathVariable String column) {
        return exampleTableService.getUniqueTables(column);
    }

    @GetMapping(value = Mapping.REPEATED_TABLE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTableModel> getRepeatedTables(@PathVariable String column) {
        return exampleTableService.getRepeatedTables(column);
    }

}
