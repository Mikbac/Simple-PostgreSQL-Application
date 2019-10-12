package com.postgres.spring.repositorie;

import com.postgres.model.ExampleTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by MikBac on 29.05.2019
 */

@Repository
public interface ExampleTableRepository extends JpaRepository<ExampleTableModel, BigInteger> {

    List<ExampleTableModel> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna1 = tt2.kolumna1) = 1")
    List<ExampleTableModel> getUniqueTable1();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna2 = tt2.kolumna2) = 1")
    List<ExampleTableModel> getUniqueTable2();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna3 = tt2.kolumna3) = 1")
    List<ExampleTableModel> getUniqueTable3();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna4 = tt2.kolumna4) = 1")
    List<ExampleTableModel> getUniqueTable4();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna1 = tt2.kolumna1) > 1")
    List<ExampleTableModel> getRepeatedTable1();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna2 = tt2.kolumna2) > 1")
    List<ExampleTableModel> getRepeatedTable2();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna3 = tt2.kolumna3) > 1")
    List<ExampleTableModel> getRepeatedTable3();

    @Query(nativeQuery = true, value = "SELECT * FROM tabela_testowa tt1  WHERE (SELECT count(*) FROM tabela_testowa tt2 WHERE tt1.kolumna4 = tt2.kolumna4) > 1")
    List<ExampleTableModel> getRepeatedTable4();
}
