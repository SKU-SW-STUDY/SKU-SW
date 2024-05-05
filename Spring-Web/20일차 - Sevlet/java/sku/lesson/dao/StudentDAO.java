package sku.lesson.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sku.lesson.dto.StudentDTO;
import sku.lesson.utils.ConnectionManager;

public class StudentDAO {
	public ArrayList<StudentDTO> select(int num){
		Connection con = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		String sql = "select * from gisa limit "+num;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		 
			while(rs.next()) {
				StudentDTO st = new StudentDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), 
						rs.getInt(3), rs.getInt(4), 
						rs.getInt(5), rs.getInt(6), 
						rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
				
				list.add(st);
			}
			
			closeConnection(rs, stmt, con);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Connection getConnection() {
		return ConnectionManager.getConnection();
	}
	
	public void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		ConnectionManager.closeConnection(rs, stmt, con);
	}
}
