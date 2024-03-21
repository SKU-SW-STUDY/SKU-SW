package sku.lesson.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sku.lesson.spring.dto.MemberDTO;

@Repository
public class MemberDAO3 {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(MemberDTO member) {
		boolean flag = false;
		int result = sqlSession.insert("mapper.member.insert", member);
		if(result > 0) flag = true;
		return flag;
	}

	public ArrayList<MemberDTO> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = null;
		list = (ArrayList)sqlSession.selectList("mapper.member.selectAll");
		return list;
	}
	
	//search
	public MemberDTO select(String id) {
		MemberDTO dto = null;
		dto = sqlSession.selectOne("mapper.member.select", id);
		System.out.println(dto);
		return dto;
	}
	//update
	public boolean update(MemberDTO dto) {
		boolean flag = false;
		int result = sqlSession.update("mapper.member.update", dto);
		if(result > 0) flag = true;
		return flag;
	}
	//delete
	public boolean delete(String id) {
		boolean flag = false;
		int result = sqlSession.delete("mapper.member.delete", id);
		if(result > 0) flag = true;
		return flag;
	}
	
	public boolean selectById(String id) {
		boolean flag = false;
		int cnt = sqlSession.selectOne("mapper.member.selectById", id);
		if(cnt > 0) flag = true;
		return flag;
	}
}






