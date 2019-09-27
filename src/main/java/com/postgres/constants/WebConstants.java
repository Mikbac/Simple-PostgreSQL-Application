package com.postgres.constants;

/**
 * Created by MikBac on 27.09.2019
 */

public interface WebConstants {

    interface Mapping {
        String ROOT = "/";
        String TABLES = ROOT + "tables";
        String TABLE = ROOT + "table";
        String UNIQUE_TABLE = ROOT + "uniqueTable/{column}";
        String REPEATED_TABLE = ROOT + "repeatedTable/{column}";
    }

    interface Views {
        String TABLE = "table";
    }

}
