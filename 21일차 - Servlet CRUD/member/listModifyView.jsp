<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sku.lesson.dto.MemberDTO"%>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
<%
	MemberDTO dto = (MemberDTO)session.getAttribute("data");
%>
<form action="/ExampleServlet?command=modify" method="Post">
<table>
	<tr>
		<td>ID</td><td><input type="text" name="userId" value="<%=dto.getUserId() %>" id="userId" readonly/></td>
	</tr>
	<tr>
		<td>name</td><td><input type="text" name="userName" value="<%=dto.getUserName() %>" id="userName" /></td>
	</tr>
	<tr>
		<td>pwd</td><td><input type="text" name="userPwd" value="<%=dto.getUserPwd() %>" id="userPwd" /></td>
	</tr>
	<tr>	
		<td>date</td><td><input type="text" name="registDate" value="<%=dto.getRegistDate() %>" id="registDate" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="modify" /></td>
	</tr>
</table>
</form>
</body>
</html>