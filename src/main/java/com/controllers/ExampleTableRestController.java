package com.controllers;


import com.models.ExampleTable;
import com.services.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tables")
public class ExampleTableRestController {

    private ExampleTableService exampleTableService;


    @Autowired
    public ExampleTableRestController(ExampleTableService exampleTableService) {
        this.exampleTableService = exampleTableService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTable> getAllTables() {
        return exampleTableService.findAll();
    }


    @RequestMapping(value = "/uniqueTable/{column}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTable> getUniqueTables(@PathVariable String column) {
        return exampleTableService.getUniqueTables(column);
    }

    @RequestMapping(value = "/repeatedTable/{column}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleTable> getRepeatedTables(@PathVariable String column) {
        return exampleTableService.getRepeatedTables(column);
    }


}
