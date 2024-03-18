package sku.lesson.spring.controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sku.lesson.spring.dto.MemberDTO;
import sku.lesson.spring.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		MemberService ms = new MemberService();
		ArrayList<MemberDTO> list = ms.getMemberData();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		return "/member/list";
	}

	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(HttpServletRequest request) {
		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("userPwd");
		
		MemberService ms = new MemberService();
		
		Timestamp date = new Timestamp(System.currentTimeMillis());
		MemberDTO dto = new MemberDTO(id, name, pwd, date);
		ms.registMember(dto);
		System.out.println(dto);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/registView", method = RequestMethod.GET)
	public String registView(HttpServletRequest request) {
		return "/member/regist";
	}
	
	@RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET} )
	public String search(HttpServletRequest request) {
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		MemberDTO dto = ms.getMemberDataOne(id);
		System.out.println("dto:"+dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("data", dto);
		return "/member/listSearch";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		if(ms.deleteMember(id)) System.out.println("success delete");
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request) {
		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("userPwd");
		
		Timestamp date = new Timestamp(System.currentTimeMillis());
		MemberDTO dto = new MemberDTO(id, name, pwd, date);
		
		MemberService ms = new MemberService();
		if(ms.modifyMember(id, dto)) System.out.println("success modify");
		
		HttpSession session = request.getSession();
		session.setAttribute("data", dto);
		return "/member/listSearch";
	}
	
	@RequestMapping(value = "/modifyView", method = RequestMethod.GET)
	public String modifyView(HttpServletRequest request) {
		String id = request.getParameter("userId");
		
		MemberService ms = new MemberService();
		MemberDTO dto = ms.getMemberDataOne(id);
		HttpSession session = request.getSession();
		session.setAttribute("data", dto);
		
		return "/member/listModifyView";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		MemberDTO dto = ms.getMemberDataOne(id);
		
		String result="fail";
		
		if(dto == null) result = "check";
		else result = "fail";
		
		HttpSession session = request.getSession();
		session.setAttribute("data", dto);
		
		System.out.println("ajax connect, id : "+id);
		return result;
	}
	
}
