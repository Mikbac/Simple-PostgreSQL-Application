package com.spring.services;

import com.model.ExampleTableModel;
import com.spring.repositories.ExampleTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by MikBac on 29.05.2019
 */

@Service
public class ExampleTableServiceImpl implements ExampleTableService {

    ExampleTableRepository exampleTableRepository;

    @Autowired
    public ExampleTableServiceImpl(ExampleTableRepository exampleTableRepository) {
        this.exampleTableRepository = exampleTableRepository;
    }

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
    public ExampleTableModel findTopById(BigInteger id) {
        return exampleTableRepository.findTopById(id);
    }

    @Override
    public List<ExampleTableModel> getUniqueTables(String column) {
        if (column.equals("kolumna1")) {
            return exampleTableRepository.getUniqueTable1();
        }
        if (column.equals("kolumna2")) {
            return exampleTableRepository.getUniqueTable2();
        }
        if (column.equals("kolumna3")) {
            return exampleTableRepository.getUniqueTable3();
        }
        if (column.equals("kolumna4")) {
            return exampleTableRepository.getUniqueTable4();
        }
        return null;
    }

    @Override
    public List<ExampleTableModel> getRepeatedTables(String column) {
        if (column.equals("kolumna1")) {
            return exampleTableRepository.getRepeatedTable1();
        }
        if (column.equals("kolumna2")) {
            return exampleTableRepository.getRepeatedTable2();
        }
        if (column.equals("kolumna3")) {
            return exampleTableRepository.getRepeatedTable3();
        }
        if (column.equals("kolumna4")) {
            return exampleTableRepository.getRepeatedTable4();
        }
        return null;
    }
}
