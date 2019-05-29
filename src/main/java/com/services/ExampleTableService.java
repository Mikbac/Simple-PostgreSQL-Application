package com.services;

import com.models.ExampleTable;

import java.math.BigInteger;
import java.util.List;

public interface ExampleTableService {

    void save(ExampleTable exampleTable);

    void saveAll(List<ExampleTable> exampleTableList);

    List<ExampleTable> findAll();

    ExampleTable findTopById(BigInteger id);

    List<ExampleTable> getUniqueTables(String column);

    List<ExampleTable> getRepeatedTables(String column);

}
