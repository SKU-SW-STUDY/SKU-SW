package sku.lesson.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sku.lesson.spring.dto.MemberDTO;
import sku.lesson.spring.service.MemberService;
import sku.lesson.spring.utils.DateService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService ms;
	
	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
	@ResponseBody
	public String checkId(String userId) {
		boolean check = ms.checkId(userId);
		return "{\"result\":"+check+"}";
	}
	
	@RequestMapping(value = "/registView", method = RequestMethod.GET)
	public String registView(Model model) {
		model.addAttribute("registDate", DateService.getDateTime(0));
		return "./member/regist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute MemberDTO dto) {
		System.out.println(dto);
		//service 에게 전달
		ms = new MemberService();
		boolean flag = ms.registMember(dto);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		ms = new MemberService();
		ArrayList<MemberDTO> list = ms.getMemberData();
		model.addAttribute("list", list);
		return "./member/list";
	}
	
	//search
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("userId") String id, HttpSession session, Model model) {
		ms = new MemberService();
		MemberDTO dto = ms.findById(id);
		model.addAttribute("dto", dto);
		System.out.println("search >>> "+id);
		return "./member/detail";
	}
	//updateview
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(@RequestParam("userId") String id, Model model) {
		ms = new MemberService();
		MemberDTO dto = ms.findById(id);
		model.addAttribute("dto", dto);
		System.out.println("update view >>> "+id);
		return "./member/update";
	}
	//update
	/*
	 * Spring은 기본 생성자를 호출하여 객체를 만든 다음에 의존성을 주입합니다. 
	 * 그러므로 Spring이 빈을 생성할 때 기본 생성자가 없으면 예외가 발생할 수 있습니다. 
	 * 때문에 Spring 컨테이너가 빈을 만들기 위해 클래스를 로드할 때, 그 클래스가 기본 생성자를 갖고 있는지를 확인합니다
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute MemberDTO dto) {
		//서비츠 요청
		ms = new MemberService();
		ms.modifyMember(dto);

		System.out.println("update >>> "+dto);
		//request.setAttribute("userId", id);
		return "redirect:search?userId="+dto.getUserId();
	}
	//delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("userId") String id) {
		ms = new MemberService();
		ms.remove(id);
		System.out.println("delete >>> "+id);
		return "redirect:list";
	}
}
