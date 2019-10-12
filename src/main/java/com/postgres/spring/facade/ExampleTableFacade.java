package com.postgres.spring.facade;

import com.postgres.model.ExampleTableModel;

import java.util.List;

/**
 * Created by MikBac on 12.10.2019
 */

public interface ExampleTableFacade {

    List<ExampleTableModel> findAll();

    List<ExampleTableModel> getUniqueTables(final String column);

    List<ExampleTableModel> getRepeatedTables(final String column);

}
