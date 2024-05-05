package sku.lesson.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	public static Connection getConnection() {
		String id = "root";
		String pw = "XXXXXXXX";		// root 비밀번호 (설치시 세팅한 번호)
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/gisa"; // 프로토콜(주 프로토콜 : jdbc, 부 프로토콜 : mysql )://주소:포트/서비스(데이터베이스 이름)
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcURL, id, pw);
			System.out.println("Database Connection Success");
			
		} catch (SQLException | ClassNotFoundException e) {
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
