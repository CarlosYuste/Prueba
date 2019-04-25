package com.ecodeup.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginCase {

	//INSERT
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		System.out.println("1");
		Connection con;
		con = ConnectionDB.getConnection();
		PreparedStatement ps = null;
		System.out.println("2");
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
			System.out.println("3");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("4");
		}
		finally {
			try {
				System.out.println("5");
				if(ps != null) {
					ps.close();
				}
			}
			catch(SQLException e){
				System.out.println("6");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//SELECT
	public static boolean selectUser(String uName) {
		System.out.println("1");
		Connection con;
		con = ConnectionDB.getConnection();
		PreparedStatement ps = null;
		System.out.println("2");
		try {
			String consulta = "SELECT * FROM usuari WHERE \"NOM\" = (?);";
			
			ps = con.prepareStatement(consulta);
			
			ps.setString(1, uName);
			
			if(ps.execute() == true) {
				return true;
				
			}
			System.out.println("3");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("4");
		}
		finally {
			try {
				System.out.println("5");
				if(ps != null) {
					ps.close();
				}
			}
			catch(SQLException e){
				System.out.println("6");
				e.printStackTrace();
			}
		}
		return false;
	}
}
