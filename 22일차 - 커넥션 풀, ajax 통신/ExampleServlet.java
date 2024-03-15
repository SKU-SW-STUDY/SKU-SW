package sku.lesson.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sku.lesson.dto.MemberDTO;
import sku.lesson.service.MemberService;

@WebServlet("/ExampleServlet") /* ANNOTATION OR web.xml*/
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExampleServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getParameter("command") == null ? "list" : request.getParameter("command");
		String url = "";
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		
		String id = "";
		String name = "";
		String pwd = "";
		Timestamp date = null;
		MemberDTO dto = null;
		
		PrintWriter pw = response.getWriter();
		boolean isAjax=false;
		if("list".equals(cmd)){	
			ArrayList<MemberDTO> list = service.getMemberData();
			session.setAttribute("list", list);
			url = "/member/list.jsp";
		}else if("regist".equals(cmd)){
			id = request.getParameter("userId");
			name = request.getParameter("userName");
			pwd = request.getParameter("userPwd");
			date = new Timestamp(System.currentTimeMillis());
			dto = new MemberDTO(id, name, pwd, date);
			service.registMember(dto);
			System.out.println(dto);
			session.setAttribute("data", dto);
			url = "/ExampleServlet?command=list";
		}else if("registView".equals(cmd)) {
			url="/member/regist.jsp";
		}else if("search".equals(cmd)) {
			id = request.getParameter("userId");
			dto = service.getMemberDataOne(id);
			System.out.println("dto:"+dto);
			session.setAttribute("data", dto);
			url="/member/listSearch.jsp";
		}else if("delete".equals(cmd)) {
			id = request.getParameter("userId");
			if(service.deleteMember(id)) System.out.println("success delete");
			url = "/ExampleServlet?command=list";
		}else if("modify".equals(cmd)) {
			id = request.getParameter("userId");
			name = request.getParameter("userName");
			pwd = request.getParameter("userPwd");
			date = new Timestamp(System.currentTimeMillis());
			dto = new MemberDTO(id, name, pwd, date);
			if(service.modifyMember(id, dto)) System.out.println("success modify");
			session.setAttribute("data", dto);
			url="/member/listSearch.jsp";
		}else if("modifyView".equals(cmd)) {
			id = request.getParameter("userId");
			dto = service.getMemberDataOne(id);
			session.setAttribute("data", dto);
			url="/member/listModifyView.jsp";
		}else if("idCheck".equals(cmd)){
			id = request.getParameter("userId");
			dto = service.getMemberDataOne(id);
			if(dto == null) pw.write("check");
			else pw.write("fail");
			pw.flush();
			System.out.println("ajax connect, id : "+id);
			isAjax = true;
		}
		
		if(!isAjax) response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
