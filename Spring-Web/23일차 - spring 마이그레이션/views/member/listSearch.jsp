<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="sku.lesson.spring.dto.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� �˻�</title>
</head>
<body>
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("data");

	if(dto == null ){
		out.print("<h1>�˻��� �����Ͱ� �����ϴ�.</h1>");
	}else{
		out.print(dto);
		out.print("<br>");
		out.print("<input type='button' value='�����ϱ�' onclick=location.href='/modifyView?userId="+dto.getUserId()+"' />");
		out.print("<input type='button' value='�����ϱ�' onclick=location.href='/delete?userId="+dto.getUserId()+"' />");
	}
%>
<a href="/list">���ư���</a>
</body>
</html>