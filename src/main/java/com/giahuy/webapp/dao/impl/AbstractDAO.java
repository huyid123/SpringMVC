package com.giahuy.webapp.dao.impl;

import com.giahuy.webapp.dao.GenericDAO;
import com.giahuy.webapp.mapper.RowMapper;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/servlet";
            String user = "root";
            String password = "giahuy123@@";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        }catch (SQLException e){
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }


    //ham update va connect db
    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeQuery();
        }catch(SQLException e){
            if (connection != null){
                try {
                    connection.rollback();
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    //ham insert va connect vao db
    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Long id = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        }catch(SQLException e){
            if (connection != null){
                try {
                    connection.rollback();
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return null;
    }

    //ham set parameter
    private void setParameter(PreparedStatement statement, Object[] parameters) {
        try{
            for (int i = 0; i < parameters.length; i++){
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long){
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String){
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Inject){
                    statement.setInt(index, (Integer)parameter);
                } else if (parameter instanceof Timestamp){
                    statement.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter instanceof  Double){
                    statement.setDouble(index, (Double) parameter);
                } else if (parameter == null){
                    statement.setNull(index, Types.NULL);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
