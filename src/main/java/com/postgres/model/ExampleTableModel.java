package com.postgres.model;

import com.postgres.constant.EntityConstants.ExampleTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by MikBac on 29.05.2019
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ExampleTable.TABLE)
public class ExampleTableModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ExampleTable.ID)
    @NotNull
    private Long id;

    @Length(max = 256)
    @Column(name = ExampleTable.COLUMN_ONE)
    @NotNull
    private String column1;

    @Length(max = 256)
    @Column(name = ExampleTable.COLUMN_TWO)
    @NotNull
    private String column2;

    @Length(max = 256)
    @Column(name = ExampleTable.COLUMN_THREE)
    @NotNull
    private String column3;

    @Column(name = ExampleTable.COLUMN_FOUR)
    @NotNull
    private Long column4;

}
