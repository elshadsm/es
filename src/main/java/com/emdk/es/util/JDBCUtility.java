package com.emdk.es.util;

import java.sql.*;

/**
 * Created by HP on 21.01.2015.
 */
public class JDBCUtility {

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

    }

    public static void close(CallableStatement callableStatement, Connection connection) throws SQLException {
        if (callableStatement != null) {
            callableStatement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    public static void close(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    public static void close(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void close(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }

    }


    public static void close(PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (resultSet != null) {
            resultSet.close();
        }

    }

    public static void close(ResultSet resultSet,Statement statement) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }

    }



}
