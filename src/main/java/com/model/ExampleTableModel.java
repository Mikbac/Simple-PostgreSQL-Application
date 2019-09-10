package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by MikBac on 29.05.2019
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tabela_testowa")
public class ExampleTableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 256)
    private String kolumna1;

    @Length(max = 256)
    private String kolumna2;

    @Length(max = 256)
    private String kolumna3;

    private Long kolumna4;

}
