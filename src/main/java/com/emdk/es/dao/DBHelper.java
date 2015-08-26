package com.emdk.es.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * Created by HP on 13.07.2015.
 */
public class DBHelper {


    private static ComboPooledDataSource dataSource;




    DBHelper(ComboPooledDataSource dataSource) {

        this.dataSource = dataSource;

    }


    public static Connection getConnection() throws Exception {

        return dataSource.getConnection();
    }






}
