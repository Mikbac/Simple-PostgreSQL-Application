package com.postgres.spring.service;

import com.postgres.model.ExampleTableModel;

import java.util.List;

/**
 * Created by MikBac on 29.05.2019
 */

public interface ExampleTableService {

    void save(ExampleTableModel exampleTableModel);

    void saveAll(List<ExampleTableModel> exampleTableModelList);

    List<ExampleTableModel> findAll();

    List<ExampleTableModel> getUniqueTables(final String column);

    List<ExampleTableModel> getRepeatedTables(final String column);

}
