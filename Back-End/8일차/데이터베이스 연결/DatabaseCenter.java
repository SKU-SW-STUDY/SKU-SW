package sku.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCenter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseCenter db = new DatabaseCenter();
		db.connectDatabase();
	}
	public void connectDatabase() {
		String id = "root";
		String pw = "XXXXXXX";		// root 비밀번호 (설치시 세팅한 번호)
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/gisa"; // 프로토콜(주 프로토콜 : jdbc, 부 프로토콜 : mysql )://주소:포트/서비스(데이터베이스 이름)
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcURL, id, pw);
			if(con!= null) {
				System.out.println("connecting database");
			}
			else {
				System.out.println("connecting fail");
			}
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
