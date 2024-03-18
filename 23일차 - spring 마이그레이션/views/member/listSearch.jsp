<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="sku.lesson.spring.dto.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 검색</title>
</head>
<body>
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("data");

	if(dto == null ){
		out.print("<h1>검색된 데이터가 없습니다.</h1>");
	}else{
		out.print(dto);
		out.print("<br>");
		out.print("<input type='button' value='수정하기' onclick=location.href='/modifyView?userId="+dto.getUserId()+"' />");
		out.print("<input type='button' value='삭제하기' onclick=location.href='/delete?userId="+dto.getUserId()+"' />");
	}
%>
<a href="/list">돌아가기</a>
</body>
</html>