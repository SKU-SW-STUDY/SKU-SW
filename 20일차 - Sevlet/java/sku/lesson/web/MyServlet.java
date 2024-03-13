package sku.lesson.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.lesson.dto.StudentDTO;
import sku.lesson.service.GisaService;


public class MyServlet extends HttpServlet {
	//브라우저 요청 처리를 한다.
	//Get Post
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
		this.doPost(req, resp);	// Get 요청으로 오면 This 함수를 이용해서 Post를 호출한다.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp로 부터 클라어언트 스트림 정보 획득
		System.out.println("post");
		//String table = req.getParameter("table") == null || "".equals(req.getParameter("table")) ? "gisa" : req.getParameter("table");
		int num = Integer.parseInt(req.getParameter("count") == null ? "0" : req.getParameter("count"));
		//QueryService qs = new QueryService();
		//String [][] result = qs.getData(table);
		GisaService gs = new GisaService();
		ArrayList<StudentDTO> result = gs.getData(num);
		
		
		/* 1. 일반 Write 
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<table>");
		for(int i = 0; i < result.length; i++) {
			out.print("<tr>");
			for(int j=0; j < result[0].length; j++) {
				out.print("<td>"+result[i][j]+"</td>");	
			}
			out.print("</tr>");
		}
		out.print("</table>");*/
		
		/* 2. Session (클라이언트, 서버 공유)
		HttpSession session = req.getSession();
		session.setAttribute("data", result);
		resp.sendRedirect("/review/table-session.jsp");
		*/
		
		/* 3. request (클라이언트, 서버 공유) */
		/*req.setAttribute("data", result);
		
        RequestDispatcher dispatcher = req.getRequestDispatcher("/review/table-req.jsp");
        dispatcher.forward(req, resp);*/
		
		req.setAttribute("data", result);
		
        RequestDispatcher dispatcher = req.getRequestDispatcher("/practice1/gisa.jsp");
        dispatcher.forward(req, resp);
		
	}
}
