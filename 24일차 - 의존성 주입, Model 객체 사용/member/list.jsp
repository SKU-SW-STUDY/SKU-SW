<%@page import="sku.lesson.spring.dto.MemberDTO"%> 
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<h1>List</h1>
<a href="./registView">등록하기</a>
<table>
<tr><td>ID</td><td>PWD</td><td>NAME</td><td>DATE</td></tr>
<%
	ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)request.getAttribute("list");
	if(list==null || list.size()==0){
		out.print("<h1>해당 데이터가 없습니다.</h1>");
	} else {
		for(MemberDTO member : list){
%>
		<tr>
			<td><a href="./search?userId=<%=member.getUserId() %>"><%=member.getUserId() %></a></td>
			<td><%=member.getUserPwd()%></td>
			<td><%=member.getUserName()%></td>
			<td><%=member.getRegistDate() %></td>
			<td><a href="./updateView?userId=<%=member.getUserId()%>">수정</a></td>
			<td><a href="./delete?userId=<%=member.getUserId()%>">삭제</a></td>
		</tr>
<%
		}
	}
%>
</table>
</body>
</html>