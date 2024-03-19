<%@page import="sku.lesson.spring.dto.MemberDTO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
<%
	MemberDTO member = (MemberDTO)request.getAttribute("dto");
%>
<form action="./list" method="post">
<table>
	<tr>
		<td>id</td><td><input type="text" name="userId" id="userId" value="${dto.userId }" readonly="readonly"></td><td></td>
	</tr>
	<tr>
		<td>name</td><td><input type="text" name="userName" id="userName" value="${dto.userName }" readonly="readonly"></td><td></td>
	</tr>
	<tr>
		<td>pwd</td><td><input type="text" name="userPwd" id="userPwd" value="${dto.userPwd }" readonly="readonly"></td><td></td>
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
		<td><input type="submit" value="to List"></td>
	</tr>
</table>
</form>
</body>
</html>