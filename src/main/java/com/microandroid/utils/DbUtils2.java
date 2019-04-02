package com.microandroid.utils;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils2 {

    public static Connection getSqliteConn() throws SQLException {
        String driverClassName = "org.sqlite.JDBC";
        String username = "SA";
        String password = "";
        String url = "jdbc:sqlite:histruts1.db";
        return getConnection(driverClassName, username, password, url);
    }

    public static Connection getConnection(String driverClassName, String username, String password, String url) throws SQLException {
        DbUtils.loadDriver(driverClassName);
        return DriverManager.getConnection(url, username, password);
    }
}
