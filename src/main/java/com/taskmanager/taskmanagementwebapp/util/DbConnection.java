package com.taskmanager.taskmanagementwebapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl"; // sənin connection string-inə uyğun düzəlt
    private static final String USER = "helpdesk";
    private static final String PASSWORD = "123456";



    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
