package com.postgres.spring.services.impl;

import com.postgres.model.ExampleTableModel;
import com.postgres.spring.repositories.ExampleTableRepository;
import com.postgres.spring.services.ExampleTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MikBac on 29.05.2019
 */

@Service
public class ExampleTableServiceImpl implements ExampleTableService {

    @Resource
    private ExampleTableRepository exampleTableRepository;

    @Override
    public void save(ExampleTableModel exampleTableModel) {
        exampleTableRepository.save(exampleTableModel);
    }

    @Override
    public void saveAll(List<ExampleTableModel> exampleTableModelList) {
        exampleTableRepository.saveAll(exampleTableModelList);
    }

    @Override
    public List<ExampleTableModel> findAll() {
        return exampleTableRepository.findAll();
    }

    @Override
    public List<ExampleTableModel> getUniqueTables(String column) {
        if (column.equals("column1")) {
            return exampleTableRepository.getUniqueTable1();
        }
        if (column.equals("column2")) {
            return exampleTableRepository.getUniqueTable2();
        }
        if (column.equals("column3")) {
            return exampleTableRepository.getUniqueTable3();
        }
        if (column.equals("column4")) {
            return exampleTableRepository.getUniqueTable4();
        }
        return null;
    }

    @Override
    public List<ExampleTableModel> getRepeatedTables(String column) {
        if (column.equals("column1")) {
            return exampleTableRepository.getRepeatedTable1();
        }
        if (column.equals("column2")) {
            return exampleTableRepository.getRepeatedTable2();
        }
        if (column.equals("column3")) {
            return exampleTableRepository.getRepeatedTable3();
        }
        if (column.equals("column4")) {
            return exampleTableRepository.getRepeatedTable4();
        }
        return null;
    }
}
