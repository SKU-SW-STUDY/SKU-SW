package sku.lesson.dao;

import java.sql.*;
import sku.lesson.utils.ConnectionManager;

public class QueryDAO {
	
	public String[] getColumnNames(String sql) {
		Connection con = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String [] result = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();	// 테이블의 메타 데이터 정보 가져오기 
			int columnCount = metaData.getColumnCount();	// 테이블의 데이터 컬럼수 가져오기 
			
			result = new String[columnCount];
			
			for(int i=1; i<=columnCount; i++){	/* 테이블 헤더를 구성 */
				result[i-1] = metaData.getColumnName(i);
			}
			
			closeConnection(rs, stmt, con);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String[][] select(String sql){
		Connection con = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String [][] result = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			String[]column = this.getColumnNames(sql);
			
			result = new String[5][column.length];
			ResultSetMetaData metaData = rs.getMetaData();	// 테이블의 메타 데이터 정보 가져오기 
			int columnCount = metaData.getColumnCount();
			int num = 0;
			while(rs.next()) {
				for (int j = 1; j <= columnCount; j++) {
					result[num][j-1] = String.valueOf(rs.getObject(j));
				}
				num++;
			}
			
			closeConnection(rs, stmt, con);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Connection getConnection() {
		return ConnectionManager.getConnection();
	}
	
	public void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		ConnectionManager.closeConnection(rs, stmt, con);
	}

}
