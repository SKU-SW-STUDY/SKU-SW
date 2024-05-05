package basic.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {	// 데이터베이스를 자바 인터페이스와 연결할 클래스 

	public static Connection getConnection() {	// 접속정보를 이용하여 데이터베이스를 연결할 함수 
		String id = "root";
		String pw = "XXXXXXXX";		
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/gisa"; 
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
	
	public static void connectionClose(ResultSet rs, Statement stmt, Connection con) {	// 연결한 객체를 종료(close) 하는 함수 
		try {
			if(rs!= null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(con != null) {
				con.close();
			}
			System.out.println("Database Connection Close Success");
		} catch (SQLException e) {
			System.out.println("Connection Close Error");
		}
	}
}
