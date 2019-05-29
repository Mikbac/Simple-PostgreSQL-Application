package com.services;


import com.models.ExampleTable;
import com.repositories.ExampleTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ExampleTableServiceImpl implements ExampleTableService {

    ExampleTableRepository exampleTableRepository;

    @Autowired
    public ExampleTableServiceImpl(ExampleTableRepository exampleTableRepository) {
        this.exampleTableRepository = exampleTableRepository;
    }

    @Override
    public void save(ExampleTable exampleTable) {
        exampleTableRepository.save(exampleTable);
    }

    @Override
    public void saveAll(List<ExampleTable> exampleTableList) {
        exampleTableRepository.saveAll(exampleTableList);
    }

    @Override
    public List<ExampleTable> findAll() {
        return exampleTableRepository.findAll();
    }

    @Override
    public ExampleTable findTopById(BigInteger id) {
        return exampleTableRepository.findTopById(id);
    }

    @Override
    public List<ExampleTable> getUniqueTables(String column) {

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
    public List<ExampleTable> getRepeatedTables(String column) {

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
