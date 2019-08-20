package com.sean.stockscraper.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public Connection getConnection() {

		String user = "sean";
		String pass = "sean";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/stock_database?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);     
			
			Class.forName(driver);
			System.out.println("here?");
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Stocks?!!!!!!");
			
			return myConn;
		}
		catch (Exception exc) {			
			return null;
		}
	}	
}
