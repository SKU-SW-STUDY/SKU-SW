<%@page import="java.util.Arrays"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mysql.cj.jdbc.result.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	String[][] values = (String[][])request.getAttribute("data");
%>

<table>

<%
	for(int i=0;i<values.length;i++){
		out.print("<tr>");
		for(int j=0;j<values[i].length;j++){
			
%>
		<td><%=values[i][j]%></td>
<%			
		}
		out.print("</tr>");
	}
%>
</table>
<a href="/review/client.html">다시 쿼리하기</a>
</body>
</html>







