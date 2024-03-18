package sku.lesson.spring.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
	
	public static Connection getConnectionOld() {
		String id = "root";
		String pw = "XXXXXXXX";		
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/gisa";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcURL, id, pw);
			System.out.println("Database Connection Success");
			
		} catch (SQLException e) {
			System.out.println("Database Error : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Database Error : " + e.getMessage());
		}
		return con;
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Context envCtx = new InitialContext();
			Context ctx = (Context)envCtx.lookup("java:/comp/env/");
			DataSource ds = (DataSource)ctx.lookup("jdbc/TestDB");
			con = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("Database Error : " + e.getMessage());
		} catch(SQLException e) {
			System.out.println("Database Error : " + e.getMessage());
		}
		return con;
	}
	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con){
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null)	con.close();
			System.out.println("Close Connection");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
