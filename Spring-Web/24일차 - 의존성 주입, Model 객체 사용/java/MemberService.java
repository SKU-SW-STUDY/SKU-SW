package sku.lesson.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sku.lesson.spring.dao.MemberDAO;
import sku.lesson.spring.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public boolean checkId(String id) {
		boolean flag = false;
		dao = new MemberDAO();
		flag = dao.selectById(id);
		return flag;
	}
	
	public boolean registMember(MemberDTO member) {
		boolean flag = false;
		dao = new MemberDAO();
		flag = dao.insert(member);
		return flag;
	}

	public ArrayList<MemberDTO> getMemberData() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = new MemberDAO().selectAll();
		return list;
	}
	//조건 조회
	public MemberDTO findById(String id) {
		MemberDTO dto = null;
		dao = new MemberDAO();
		dto = dao.select(id);
		return dto;
	}
	//수정
	public boolean modifyMember(MemberDTO dto) {
		boolean flag = false;
		dao = new MemberDAO();
		dao.update(dto);
		return flag;
	}
	//삭제
	public boolean remove(String id) {
		boolean flag = false;
		flag = new MemberDAO().delete(id);
		return flag;
	}
}
