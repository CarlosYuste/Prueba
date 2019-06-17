package com.ecodeup.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 
 * @author Laptop-06
 *conexion a la base de datos
 */
public class ConnectionDB {
	private static Logger logger = Logger.getLogger("Warning");

	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\Laptop-06\\eclipse-workspace\\WEB\\WebContent\\WEB-INF\\db\\srv_db";
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,"SA",password());
			
		}catch(ClassNotFoundException | SQLException e) {
			logger.info("Error: "+e);
		}
		return conn;
	}
	private ConnectionDB() {
		super();
	}
	private static String password() {
		return "";
	}
}
