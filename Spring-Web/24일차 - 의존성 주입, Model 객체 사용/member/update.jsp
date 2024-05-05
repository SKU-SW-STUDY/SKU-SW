<%@page import="java.sql.Timestamp"%>
<%@page import="sku.lesson.spring.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<h1>Update</h1>
	<%
	MemberDTO member = null;
	member = (MemberDTO)request.getAttribute("dto");
%>
<form action="./update" method="post">
<table>
	<tr>
		<td>id</td><td><input type="text" name="userId" id="userId" value="${dto.userId }" readonly="readonly"></td><td></td>
	</tr>
	<tr>
		<td>name</td><td><input type="text" name="userName" id="userName" value="${dto.userName }"></td><td></td>
	</tr>
	<tr>
		<td>pwd</td><td><input type="text" name="userPwd" id="userPwd" value="${dto.userPwd }"></td><td></td>
	</tr>
	<tr>
		<td>date</td>
		<td>
			<input type="text" name="registDate" id="registDate" 
							value="${dto.registDate}" 
							readonly="readonly">
		</td>
		<td></td>
	</tr>
	<tr>
		<td><input type="submit" value="update"></td>
	</tr>
</table>
</form>
</body>
</html>