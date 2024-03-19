package sku.lesson.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import sku.lesson.spring.dto.MemberDTO;
import sku.lesson.spring.utils.ConnectionManager;

@Component
public class MemberDAO {
	public boolean insert(MemberDTO member) {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into member values (?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			//pstmt.setTimestamp(4, member.getRegistDate());
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount>0) {
				flag = true;
			}
			ConnectionManager.closeConnection(null, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	public ArrayList<MemberDTO> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = null;
		list = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		String sql = "select * from member";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				Timestamp date = rs.getTimestamp(4);
				member = new MemberDTO(id, name, pwd, date);
				list.add(member);
			}
			ConnectionManager.closeConnection(rs, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//search
	public MemberDTO select(String id) {
		MemberDTO dto = null;
		String sql = "select * from member where userId = ?";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				Timestamp date = rs.getTimestamp(4);
				dto = new MemberDTO(id, name, pwd, date);
			}
			ConnectionManager.closeConnection(rs, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	//update
	public boolean update(MemberDTO dto) {
		boolean flag = false;
		String sql = "update member set userPwd = ?, userName=? where userId = ?";
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserPwd());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getUserId());
			int affectedCount = pstmt.executeUpdate();
			ConnectionManager.closeConnection(null, pstmt, con);
			if(affectedCount>0) {
				flag = true;
			}
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return flag;
	}
	//delete
	public boolean delete(String id) {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "delete from member where userId = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount>0) {
				flag = true;
			}
			ConnectionManager.closeConnection(null, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean selectById(String id) {
		boolean flag = false;
		String sql = "select * from member where userId = ?";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				flag = true;
			}
			ConnectionManager.closeConnection(rs, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}






