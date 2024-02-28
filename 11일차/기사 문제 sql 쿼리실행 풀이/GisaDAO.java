package basic.lesson.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import sku.lesson.db.try1.ConnectionManager;

public class GisaDAO {	// 데이터베이스 튜플에 매핑할 클래스 
	
	public String selectQuiz1(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String result = "";
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				result = rs.getString("std_no");
			}
			
			ConnectionManager.connectionClose(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		return result;
	}
	
	public String selectQuiz2(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String result = "";
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				result = rs.getString("maxScore");
			}
			
			ConnectionManager.connectionClose(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		return result;
	}
	
	public String selectQuiz3(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String result = "";
		//String result = "", code = "";
		//int sum = 0;
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				/*sum += rs.getInt("total");
				code = rs.getString("acc_code");
				
				if("A".equals(code)) sum+=5;
				else if("B".equals(code)) sum+=15;
				else sum+=20;*/
				
				result = rs.getString("point");
			}
			
			//result = String.valueOf(sum);
			ConnectionManager.connectionClose(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		return result;
	}
	
	public String selectQuiz4(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String result = "";
		//String result = "", code = "";
		//int sum=0, count=0;
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				/*sum = rs.getInt("kor");
				code = rs.getString("loc_code");
				
				if("A".equals(code)) sum+=5;
				else if("B".equals(code)) sum+=10;
				else sum+=15;
				
				if(sum >= 50) count++;*/
				
				result = rs.getString("cnt");
			}
			
			//result = String.valueOf(count);
			ConnectionManager.connectionClose(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		return result;
	}

}
