package com.jsystems.qa.qaapi.database;

import com.jsystems.qa.qaapi.model.UserDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static UserDb getOneById(Long id) {
        String sql = "select * from testuser where id = " + id;
        UserDb userDb = new UserDb();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sql);
            while (wynik.next()) {
                userDb.setId(wynik.getLong(1));
                userDb.setName(wynik.getString(2));
                userDb.setSurname(wynik.getString(3));
            }
            wynik.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDb;
    }

    public static List<UserDb> getAllUsers(){
        List<UserDb> users = new ArrayList<>();
        String sqlAll = "select * from testuser";

        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sqlAll);
            while (wynik.next()) {
               UserDb user = new UserDb(wynik.getLong(1), wynik.getString(2), wynik.getString(3));
               users.add(user);
            }
            wynik.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void saveUser(UserDb userDb) {
        String sql = "insert into testuser (id, name, surname) values ("+ userDb.getId() +
                ",'" + userDb.getName() + "','" + userDb.getSurname() + "')";
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            statement.executeQuery(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(long id) {
        String sql = "delete testuser where id = " +id;
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            statement.executeQuery(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(UserDb userDb, long id) {
        String sql = "update testuser set id = " + userDb.getId() + ", name = "
                + userDb.getName() + ", surname = " + userDb.getSurname() +
                " where id = " + id;
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            statement.executeQuery(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
