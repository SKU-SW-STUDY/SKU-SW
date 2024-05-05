package sku.practice.dbClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientDAO {
	public ArrayList<HashMap<String, String>> select(String sql) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, String>> list = null;
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			HashMap<String, String> map;
			list = new ArrayList<HashMap<String, String>>();
			
			int count = rs.getMetaData().getColumnCount();
		
			
			while(rs.next()){
				map = new HashMap<String, String>();
				
				for(int i=0; i<count; i++) {
					// 작업실시 데이터클래스 없이 rs의 내용을 클라이언트에게 어떻게 전달할 것인가? Map 으로 전달 
					map.put(String.valueOf(i+1), rs.getString(i+1));
					
				}
				// 작업실시 데이터클래스 없이 rs의 내용을 클라이언트에게 어떻게 전달할 것인가? Map 으로 전달 
				/*map.put("std_no", rs.getString(1));
				map.put("email", rs.getString(2));
				map.put("total", rs.getString(3));
				map.put("mag_code", rs.getString(4));*/
				
				list.add(map);
			}
			
			ConnectionManager.closeConnection(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("Select Error:"+e.getMessage());
		}
		
		return list;
	}
}
