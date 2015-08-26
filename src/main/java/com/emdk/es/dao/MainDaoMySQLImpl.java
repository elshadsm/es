package com.emdk.es.dao;

import com.emdk.es.util.JDBCUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 25.08.2015.
 */

@Repository
public class MainDaoMySQLImpl implements MainDao{


    private static final Logger logger = LogManager.getLogger();


    @Override
    public boolean updateExample(int id, String value) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {

            connection = DBHelper.getConnection();

            preparedStatement = connection.prepareStatement(SQLQueries.UPDATE_QUERY);

            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);


            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }


        } catch (Exception ex) {
            logger.error("There is a problem with the selecting data from the database: (updateExample) id="+id+" value="+value, ex);
        } finally {

            try {
                JDBCUtility.close(preparedStatement, connection);
            } catch (Exception exc) {
                logger.error("There is a problem with the closing PreparedStatement and Connection from the database: (updateExample)id="+id+" value="+value, exc);
            }

        }


        return false;
    }

    @Override
    public String selectExample(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

       String value = null;

        try {
            connection = DBHelper.getConnection();

            preparedStatement = connection.prepareStatement(SQLQueries.SELECT_QUERY);


            preparedStatement.setInt(1, id);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                value = resultSet.getString("VALUE");
            }



        } catch (Exception ex) {
            logger.error("There is a problem with the selecting data from the database: (selectExample) id="+id, ex);
        } finally {

            try {
                JDBCUtility.close(resultSet, preparedStatement, connection);
            } catch (Exception exc) {
                logger.error("There is a problem with the closing  ResultSet,PreparedStatement and Connection from the database: (selectExample)id="+id, exc);
            }

        }

        return value;

    }

    @Override
    public int insertExample(int id, Date date) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {

            connection = DBHelper.getConnection();


            preparedStatement = connection.prepareStatement(SQLQueries.INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);


            preparedStatement.setInt(1, id);
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));


            preparedStatement.executeUpdate();


            resultSet = preparedStatement.getGeneratedKeys();


            while (resultSet.next()) {

                return resultSet.getInt(1);
            }


        } catch (Exception ex) {
            logger.error("There is a problem with the selecting data from the database: (insertExample) id="+id+"date="+date, ex);
        } finally {

            try {
                JDBCUtility.close(resultSet, preparedStatement, connection);
            } catch (Exception exc) {
                logger.error("There is a problem with the closing  ResultSet, PreparedStatement and Connection from the database: (insertExample) id="+id+"date="+date, exc);
            }

        }


        return -1;
    }

    @Override
    public boolean deleteExample(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {

            connection = DBHelper.getConnection();

            preparedStatement = connection.prepareStatement(SQLQueries.DELETE_QUERY);

            preparedStatement.setInt(1, id);


            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }


        } catch (Exception ex) {
            logger.error("There is a problem with the selecting data from the database: (deleteExample) id="+id, ex);
        } finally {

            try {
                JDBCUtility.close(preparedStatement, connection);
            } catch (Exception exc) {
                logger.error("There is a problem with the closing PreparedStatement and Connection from the database: (deleteExample) id="+id, exc);
            }

        }


        return false;


    }

    @Override
    public List<Integer> selectListExample() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        List<Integer> idList = new ArrayList<Integer>();

        int id;

        try {
            connection = DBHelper.getConnection();

            preparedStatement = connection.prepareStatement(SQLQueries.SELECT_LIST_QUERY);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                id = resultSet.getInt("ID");

                idList.add(id);


            }



        } catch (Exception ex) {
            logger.error("There is a problem with the selecting data from the database: (selectListExample)", ex);
        } finally {

            try {
                JDBCUtility.close(resultSet, preparedStatement, connection);
            } catch (Exception exc) {
                logger.error("There is a problem with the closing  ResultSet,PreparedStatement and Connection from the database: (selectListExample) ", exc);
            }

        }

        return idList;

    }


}
