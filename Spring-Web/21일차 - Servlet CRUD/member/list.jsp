<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="sku.lesson.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>list</title>
</head>
<body>
<%
	ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) session.getAttribute("list");

	if(list == null || list.size() == 0){
		out.print("<h1>해당 데이터가 없습니다.</h1>");
	}else{
		for(MemberDTO member : list){
			out.print(member+"<br>");			
		}
	}
%>
</body>
</html>