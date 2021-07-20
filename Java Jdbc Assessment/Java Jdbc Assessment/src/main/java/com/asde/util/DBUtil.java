package com.asde.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBUtil {
    private static String url; 
    private static String username; 
    private static String password; 
    private static String driverClassName; 

    static {
        ResourceBundle rb = ResourceBundle.getBundle("application"); 
        url = rb.getString("db.url"); 
        username = rb.getString("db.username"); 
        password = rb.getString("db.password");
        driverClassName = rb.getString("db.driver"); 
        System.out.println("--- "+driverClassName);
    }
    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName); 
        return DriverManager.getConnection(url, username, password); 
    }

    // public static void main(String[] args) throws ClassNotFoundException, SQLException {
    //     System.out.println(createConnection());
    // }

}   

