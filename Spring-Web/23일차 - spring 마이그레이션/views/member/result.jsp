<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sku.lesson.spring.dto.MemberDTO"%>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<body>
<%
	MemberDTO dto = (MemberDTO)session.getAttribute("data");
%>
<table>
	<tr>
		<td>ID</td><td><%=dto.getUserId() %></td>
	</tr>
	<tr>
		<td>name</td><td><%=dto.getUserName() %></td>
	</tr>
	<tr>
		<td>pwd</td><td><%=dto.getUserPwd() %></td>
	</tr>
	<tr>	
		<td>date</td><td><%=dto.getRegistDate() %></td>
	</tr>
</table>
</body>
</html>