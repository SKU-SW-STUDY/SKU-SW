package sku.lesson.db.try1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GisaDAO {

	public boolean insert(String sql) {		/* sql 문을 받아 Insert */
		boolean flag = false;
		
		Connection con = null;
		Statement stmt = null;
	
		try {
			con = ConnectionManager.getConnection();
			stmt =  con.createStatement();
			int affectedCount =  stmt.executeUpdate(sql);
			ConnectionManager.connectionClose(null, stmt, con);
			
			if(affectedCount > 0) flag = true;	// insert 한 레코드 수만큼 리턴
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		
		return flag;
	}
	
	public boolean insert(Student student) {	/* 학생객체를 받아 Insert */
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into gisa values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getEmail());
			pstmt.setInt(3, student.getK_score());
			pstmt.setInt(4, student.getE_score());
			pstmt.setInt(5, student.getM_score());
			pstmt.setInt(6, student.getS_score());
			pstmt.setInt(7, student.getH_score());
			pstmt.setInt(8, student.getTotal_score());
			pstmt.setString(9, student.getTecher_code());
			pstmt.setString(10, student.getGood_code());
			pstmt.setString(11, student.getRegion_code());
			
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount > 0) flag = true;	// insert 한 레코드 수만큼 리턴
			
			ConnectionManager.connectionClose(null, pstmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		return flag;
	}
	
	public boolean insert(ArrayList<Student> list) {	/* 학생객체를 list로 받아 Insert */
		/* 1. connection 고려없이 함수 실행하는 방법, 실행 시간: 6960밀리초 */
		
		/*int count = 0;
		
		for(Student st : list) {
			if(this.insert(st)) count++;
		}
		return count == list.size() ? true : false;
		
		*/
		
		
		/* 2.connection 1회로 실행하는 방법,
		 *  
		 * 일반 실행 시간: 2078밀리초 
		 * Batch 실행 시간: 2091밀리초
		 * */
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into gisa values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int count = 0;
		
		try {
			
			con = ConnectionManager.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			for(Student st : list) {
				pstmt.setInt(1, st.getStdNo());
				pstmt.setString(2, st.getEmail());
				pstmt.setInt(3, st.getK_score());
				pstmt.setInt(4, st.getE_score());
				pstmt.setInt(5, st.getM_score());
				pstmt.setInt(6, st.getS_score());
				pstmt.setInt(7, st.getH_score());
				pstmt.setInt(8, st.getTotal_score());
				pstmt.setString(9, st.getTecher_code());
				pstmt.setString(10, st.getGood_code());
				pstmt.setString(11, st.getRegion_code());
			
				int affectedCount = pstmt.executeUpdate();
				if(affectedCount > 0) count ++;
				
				
				//pstmt.addBatch();				/* Batch에 추가 */
				//pstmt.clearParameters();		/* pstmt에 세팅된 파라미터 clear */
			}
			
			//pstmt.executeBatch();				/* Batch 실행 */
			
			//pstmt.clearBatch();				/*쌓여진 Batch clear */
			
			ConnectionManager.connectionClose(null, pstmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		
		return count == list.size() ? true : false;
		//return true;
	}
	
	public void select(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//행처리
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();

				for (int i = 1; i <= columnCount; i++) {
					//String columnName = metaData.getColumnName(i);
					Object columnValue = rs.getObject(i);
					System.out.print(columnValue + ",");
				}
				System.out.println();

			}
			
			ConnectionManager.connectionClose(null, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
	}
	
	public boolean delete(String sql) {
		boolean flag = false;
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = ConnectionManager.getConnection();
			stmt =  con.createStatement();
			int affectedCount =  stmt.executeUpdate(sql);
			ConnectionManager.connectionClose(null, stmt, con);
			
			if(affectedCount > 0) flag = true;// delete 한 레코드 수만큼 리턴
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		
		return flag;
		
	}
}
