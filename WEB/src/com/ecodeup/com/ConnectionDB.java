package com.ecodeup.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\Laptop-06\\eclipse-workspace\\WEB\\WebContent\\WEB-INF\\db\\srv_db";
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,"SA","");
			
		}catch(ClassNotFoundException | SQLException e) {
			System.err.println("Error: "+e);
		}
		return conn;
	}
	public ConnectionDB() {
		super();
	}
}
