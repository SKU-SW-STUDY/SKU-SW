<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sku.lesson.utils.DateService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="/ExampleServlet?command=regist" method="Post">
<table>
	<tr>
		<td>ID</td><td><input type="text" name="userId" id="userId" /></td>
	</tr>
	<tr>
		<td>name</td><td><input type="text" name="userName" id="userName" /></td>
	</tr>
	<tr>
		<td>pwd</td><td><input type="text" name="userPwd" id="userPwd" /></td>
	</tr>
	<tr>	
		<td>date</td><td><input type="text" name="registDate" id="registDate" value="<%=DateService.getDateTime(0)%>" readonly /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="regist" /></td>
	</tr>
</table>
</form>
</body>
</html>