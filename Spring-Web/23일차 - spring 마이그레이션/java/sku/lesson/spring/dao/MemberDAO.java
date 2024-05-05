package sku.lesson.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import sku.lesson.spring.dto.MemberDTO;
import sku.lesson.spring.utils.ConnectionManager;


public class MemberDAO {
	
	public boolean insert(MemberDTO dto) {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values (?, ?, ?, ?);";
		
		try {
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getUserPwd());
			pstmt.setTimestamp(4, dto.getRegistDate());
					
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount > 0) flag = true;	// insert 한 레코드 수만큼 리턴
			
			ConnectionManager.closeConnection(null, pstmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		
		return flag;
	}

	public ArrayList<MemberDTO> selectAll() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		String sql = "select * from member";
		
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				Timestamp date = rs.getTimestamp(4);
				member = new MemberDTO(id, name, pwd, date);
				list.add(member);
			}
			
					
			ConnectionManager.closeConnection(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		return list;
	}

	public MemberDTO select(String id) {		// 조회
		MemberDTO member = null;
		String sql = "select * from member where userId = '"+id+"';";
		
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
			}
			
			ConnectionManager.closeConnection(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		return member;
	}

	public boolean delete(String id) {			// 삭제 
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where userId = ?";
		
		try {
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
					
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount > 0) flag = true;	// insert 한 레코드 수만큼 리턴
			
			ConnectionManager.closeConnection(null, pstmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		
		return flag;
	}

	public boolean modify(String id, MemberDTO dto) {			// 수정
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "update member set userPwd = ?, userName = ?, registDate = ? where userId = ?;";
		
		try {
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setTimestamp(3, dto.getRegistDate());
			pstmt.setString(4, id);
			
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount > 0) flag = true;	// insert 한 레코드 수만큼 리턴
			
			ConnectionManager.closeConnection(null, pstmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error : "+e.getMessage());
		}
		
		return flag;
	}

}
