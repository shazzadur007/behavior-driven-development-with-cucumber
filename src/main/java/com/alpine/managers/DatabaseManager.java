package com.alpine.managers;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public DatabaseManager() {
//        System.setProperty("ACTIVE_ENV", "test");
//        org.javalite.activejdbc.connection_config.DBConfiguration.loadConfiguration("configs/database.properties");
//        new DB("default").open();
//        if (!Base.hasConnection()) {
//            Base.open("com.mysql.jdbc.Driver",
//                    "jdbc:mysql://localhost:3307/alpine_qa",
//                    "root", "password");
//        }
    }

    public void openDatabase() {
        if (!Base.hasConnection()) {
//            Base.open("com.mysql.jdbc.Driver",
//                    "jdbc:mysql://localhost:3307/alpine_qa",
//                    "root", "password");

            new DB("default").open();
        }
    }

    public Connection getConnection() {
        return Base.connection();
    }

    public Statement getStatement() {
        try {
            Connection connection = Base.connection();
            return connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void closeDatabase() {
//        Base.close();
        new DB("default").close();
    }
}
