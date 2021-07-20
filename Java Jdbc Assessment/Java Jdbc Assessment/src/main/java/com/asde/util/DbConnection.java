package com.asde.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DbConnection {
	private String databaseURL;
	private String username;
	private String password;
	private String dbName;
    private String driver; 

	public DbConnection(Properties props) {
        this.databaseURL = props.getProperty("db.url");
        this.username = props.getProperty("db.username");
        this.password = props.getProperty("db.password");
        this.dbName = props.getProperty("db.name");
        this.driver = props.getProperty("db.driver");
	}
	
	/**
     * get database connection
     * 
     * @param databaseURL
     * @param username
     * @param password
     * @param driver
     */
    public Connection getDbConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            String completeDBURL = databaseURL + dbName;
            con = DriverManager.getConnection(completeDBURL, username, password);
        } catch (Exception e) {
            System.out.println("Exception occured while getting a db connection");
        }
        return con;
    }
   
}
