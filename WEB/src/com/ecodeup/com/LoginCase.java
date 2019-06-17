package com.ecodeup.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
/**
 * 
 * @author Laptop-06
 *
 */
public class LoginCase {
	private static Logger logger = Logger.getLogger("Warning");
	//Constructor Privat
	private LoginCase(){
		
	}
/**
 * 
 * @param uName  Para saber el nombre que escriben en el input
 * @param uPass  Para saber la contraseña que escriben en el input
 * @param uEmail Para saber el Email que ponen en el input
 * @return Devuleve true si la consulta y false si es incorrecta
 */
	//INSERT
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		logger.info("1");
		Connection con;
		con = ConnectionDB.getConnection();
		PreparedStatement ps = null;
		logger.info("2");
		try {
			String consulta = "insert into \"PUBLIC\".\"USUARI\" (\"NOM\",\"PWD\",\"EMAIL\") "
							+ "VALUES(?,?,?);";
			ps = con.prepareStatement(consulta);
			
			ps.setString(1, uName);
			ps.setString(2, uPass);
			ps.setString(3, uEmail);
			
			if(ps.executeUpdate() == 1) {
				return true;
				
			}
			logger.info("3");
		}
		catch(SQLException e) {
			e.printStackTrace();
			logger.info("4");
		}
		finally {
			try {
				logger.info("5");
				if(ps != null) {
					ps.close();
				}
			}
			catch(SQLException e){
				logger.info("6");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//SELECT
	public static boolean selectUser(String uName) {
		logger.info("1");
		Connection con;
		con = ConnectionDB.getConnection();
		PreparedStatement ps = null;
		logger.info("2");
		try {
			String consulta = "SELECT * FROM usuari WHERE \"NOM\" = (?);";
			
			ps = con.prepareStatement(consulta);
			
			ps.setString(1, uName);
			
			if(ps.execute() == true) {
				return true;
				
			}
			logger.info("3");
		}
		catch(SQLException e) {
			e.printStackTrace();
			logger.info("4");
		}
		finally {
			try {
				logger.info("5");
				if(ps != null) {
					ps.close();
				}
			}
			catch(SQLException e){
				logger.info("6");
				e.printStackTrace();
			}
		}
		return false;
	}
}
