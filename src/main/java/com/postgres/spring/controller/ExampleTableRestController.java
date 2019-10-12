package com.postgres.spring.controller;

import com.postgres.constant.WebConstants.Mapping;
import com.postgres.model.ExampleTableModel;
import com.postgres.spring.facade.ExampleTableFacade;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MikBac on 29.05.2019
 */

@CrossOrigin
@RestController
@RequestMapping(Mapping.TABLES)
public class ExampleTableRestController {

    @Resource
    private ExampleTableFacade exampleTableFacade;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTableModel> getAllTables() {
        return exampleTableFacade.findAll();
    }

    @GetMapping(value = Mapping.UNIQUE_TABLE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTableModel> getUniqueTables(@PathVariable String column) {
        return exampleTableFacade.getUniqueTables(column);
    }

    @GetMapping(value = Mapping.REPEATED_TABLE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTableModel> getRepeatedTables(@PathVariable String column) {
        return exampleTableFacade.getRepeatedTables(column);
    }

}
