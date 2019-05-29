package com.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tabela_testowa")
public class ExampleTable {

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
