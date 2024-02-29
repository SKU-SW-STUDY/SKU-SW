package sku.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	public static Connection getConnection() {
		String id = "root";
		String pw = "XXXXXXXX";
		String url = "jdbc:mysql://localhost:3306/gisa";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);	// Connection 연결코드 (DriverManager 객체 활용하기)
		} catch (SQLException e) {
			System.out.println("Database Connection Error: "+e.getMessage());
		}
		return con;
	}
	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			System.out.println("Connection Close Error :"+e.getMessage());
		}
	}
}
