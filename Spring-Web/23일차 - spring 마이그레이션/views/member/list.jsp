<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@page import="sku.lesson.spring.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list 요청</title>
</head>
<body>
<a href="/registView">회원가입 하기</a>
<br>
<br>
<form action="/member/search" method="Post">
	ID: <input type="text" name="userId" placeholder="아이디를 입력해주세요">
	<input type="submit" value="검색">
</form>

<table>
<%
	ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)session.getAttribute("list");
	if(list==null || list.size()==0){
		out.print("<h1>해당 데이터가 없습니다.</h1>");
	} else {
		for(MemberDTO member : list){
%>
		<tr>
			<td><a href="/member/search?userId=<%=member.getUserId() %>"><%=member.getUserId() %></a></td>
			<td><%=member.getUserPwd()%></td>
			<td><%=member.getUserName()%></td>
			<td><%=member.getRegistDate() %></td>
			<td><a href="/member/modifyView?userId=<%=member.getUserId()%>">수정</a></td>
			<td><a href="/member/delete?userId=<%=member.getUserId()%>">삭제</a></td>
		</tr>
<%
		}
	}
%>
</table>
</body>
</html>