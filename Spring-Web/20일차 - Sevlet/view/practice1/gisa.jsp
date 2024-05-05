<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mysql.cj.jdbc.result.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sku.lesson.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database</title>
<style>
	table {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	tr, td {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
</style>
</head>
<body>
<%
	Object values = request.getAttribute("data");
	ArrayList<StudentDTO> list = (ArrayList<StudentDTO>) values;
%>

<table>
	<tr>	
		<td>Std_No</td>
		<td>Email</td>
		<td>Kor</td>
		<td>Eng</td>
		<td>Math</td>
		<td>Sci</td>
		<td>Hist</td>
		<td>Total</td>
		<td>Mag_Code</td>
		<td>Acc_Code</td>
		<td>Loc_COde</td>
	</tr>
<%
	for(int i=0;i<list.size();i++){
		StudentDTO st = list.get(i);
		out.print("<tr>");
%>
		<td><%=st.getStd_no()%></td>
		<td><%=st.getEmail()%></td>
		<td><%=st.getKor()%></td>
		<td><%=st.getEng()%></td>
		<td><%=st.getMath()%></td>
		<td><%=st.getSci()%></td>
		<td><%=st.getHist()%></td>
		<td><%=st.getTotal()%></td>
		<td><%=st.getMag_code()%></td>
		<td><%=st.getAcc_code()%></td>
		<td><%=st.getLoc_code()%></td>
<%			
		out.print("</tr>");
	}
%>
</table>
<a href="/practice1/gisa.html">다시 쿼리하기</a>
</body>
</html>