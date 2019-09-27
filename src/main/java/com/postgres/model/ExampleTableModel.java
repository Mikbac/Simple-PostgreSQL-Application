package com.postgres.model;

import com.postgres.constants.EntityConstants.ExampleTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MikBac on 29.05.2019
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ExampleTable.TABLE)
public class ExampleTableModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ExampleTable.ID)
    private Long id;

    @Length(max = 256)
    @Column(name = ExampleTable.COLUMN_ONE)
    private String column1;

    @Length(max = 256)
    @Column(name = ExampleTable.COLUMN_TWO)
    private String column2;

    @Length(max = 256)
    @Column(name = ExampleTable.COLUMN_THREE)
    private String column3;

    @Column(name = ExampleTable.COLUMN_FOUR)
    private Long column4;

}
