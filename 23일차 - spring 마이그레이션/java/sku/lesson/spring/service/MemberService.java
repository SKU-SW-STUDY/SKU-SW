package sku.lesson.spring.service;

import java.util.ArrayList;

import sku.lesson.spring.dao.MemberDAO;
import sku.lesson.spring.dto.MemberDTO;

public class MemberService {
	
	public boolean registMember(MemberDTO member) {
		MemberDAO dao = new MemberDAO();
		return dao.insert(member);
	}

	public ArrayList<MemberDTO> getMemberData() {
		MemberDAO dao = new MemberDAO();
		
		return dao.selectAll();
	}

	public MemberDTO getMemberDataOne(String id) {		// 검색 
		MemberDAO dao = new MemberDAO();
		return dao.select(id);
	}
	
	public boolean deleteMember(String id) {
		MemberDAO dao = new MemberDAO();
		return dao.delete(id);
	}
	
	public boolean modifyMember(String id, MemberDTO member) {
		MemberDAO dao = new MemberDAO();
		return dao.modify(id, member);
	}
}
