package com.repositories;

import com.models.ExampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ExampleTableRepository extends JpaRepository<ExampleTable, BigInteger> {

    List<ExampleTable> findAll();

    ExampleTable findTopById(BigInteger id);


    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna1 = tt2.kolumna1) = 1")
    List<ExampleTable> getUniqueTable1();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna2 = tt2.kolumna2) = 1")
    List<ExampleTable> getUniqueTable2();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna3 = tt2.kolumna3) = 1")
    List<ExampleTable> getUniqueTable3();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna4 = tt2.kolumna4) = 1")
    List<ExampleTable> getUniqueTable4();


    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna1 = tt2.kolumna1) > 1")
    List<ExampleTable> getRepeatedTable1();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna2 = tt2.kolumna2) > 1")
    List<ExampleTable> getRepeatedTable2();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna3 = tt2.kolumna3) > 1")
    List<ExampleTable> getRepeatedTable3();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna4 = tt2.kolumna4) > 1")
    List<ExampleTable> getRepeatedTable4();
}
