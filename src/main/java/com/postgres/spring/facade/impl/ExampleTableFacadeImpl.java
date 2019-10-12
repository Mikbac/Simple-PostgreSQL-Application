package com.postgres.spring.facade.impl;

import com.postgres.model.ExampleTableModel;
import com.postgres.spring.facade.ExampleTableFacade;
import com.postgres.spring.service.ExampleTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MikBac on 12.10.2019
 */

@Service
public class ExampleTableFacadeImpl implements ExampleTableFacade {

    @Resource
    private ExampleTableService exampleTableService;

    @Override
    public List<ExampleTableModel> findAll() {
        return exampleTableService.findAll();
    }

    @Override
    public List<ExampleTableModel> getUniqueTables(final String column) {
        return exampleTableService.getUniqueTables(column);
    }

    @Override
    public List<ExampleTableModel> getRepeatedTables(final String column) {
        return exampleTableService.getRepeatedTables(column);
    }
}
