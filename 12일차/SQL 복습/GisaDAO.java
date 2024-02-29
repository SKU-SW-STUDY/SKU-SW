package sku.lesson.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class GisaDAO {

	public String quizSolve(String sql) {
		String answer = "";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				answer = rs.getString("answer");
			}
			
			ConnectionManager.closeConnection(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("SQL quiz1Solve Error:"+e.getMessage());
		}
		
		return answer;
	}
	
	public boolean insert(ArrayList<Student> list){
		String sql = "insert into gisa values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int affectedCount = 0;
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			int count = 0;
			con.setAutoCommit(false);
			for(Student st : list) {
				pstmt.setInt(1, st.getStd_no());
				pstmt.setString(2, st.getEmail());
				pstmt.setInt(3, st.getKor());
				pstmt.setInt(4, st.getEng());
				pstmt.setInt(5, st.getMath());
				pstmt.setInt(6, st.getSci());
				pstmt.setInt(7, st.getHist());
				pstmt.setInt(8, st.getTotal());
				pstmt.setString(9, st.getMag_code());
				pstmt.setString(10, st.getAcc_code());
				pstmt.setString(11, st.getLoc_code());
				pstmt.addBatch();
				
				count ++;
				
				if(count%100 == 0) {
					System.out.println("Start Batch Insert!");
					int []arr = pstmt.executeBatch();
					affectedCount += arr.length;
				}
			}
			pstmt.executeBatch();
			
			con.commit();
			con.setAutoCommit(true);
			
			ConnectionManager.closeConnection(null, pstmt, con);
		} catch (SQLException e) {
			try {
				con.rollback();
				con.setAutoCommit(false);
				System.out.println("Batch Insert Error: "+e.getMessage());
			} catch (SQLException e1) {
				System.out.println("Batch Insert RollBack Error: "+e.getMessage());
			}
			
		}
		
		return affectedCount == list.size() ? true : false;
		
	}
}
