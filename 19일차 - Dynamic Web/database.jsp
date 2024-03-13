<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Database</title>
<style>
table{
	border-collapse:collapse;
}

td{
	border:1px solid black;
	text-align:center;
	width:100px;
}
</style>
</head>
<body>
<%
	String id = "root";
	String pw = "XXXXXXX";		
	String driver = "com.mysql.cj.jdbc.Driver";
	String jdbcURL = "jdbc:mysql://localhost:3306/gisa"; 
	Connection con = null;
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(jdbcURL, id, pw);
		System.out.println("Database Connection Success");
		
		Statement stmt = null;
		ResultSet rs = null;
		
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from gisa limit 10");
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>학번</td>");
		out.println("<td>이메일</td>");
		out.println("<td>국어점수</td>");
		out.println("<td>영어점수</td>");
		out.println("<td>수학점수</td>");
		out.println("<td>과학점수</td>");
		out.println("<td>국사점수</td>");
		out.println("<td>총점</td>");
		out.println("<td>담임코드</td>");
		out.println("<td>성취도</td>");
		out.println("<td>지역코드</td>");
		out.println("</tr>");
		
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getString(5)+"</td>");
			out.println("<td>"+rs.getString(6)+"</td>");
			out.println("<td>"+rs.getString(7)+"</td>");
			out.println("<td>"+rs.getString(8)+"</td>");
			out.println("<td>"+rs.getString(9)+"</td>");
			out.println("<td>"+rs.getString(10)+"</td>");
			out.println("<td>"+rs.getString(11)+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		try {
			if(rs!= null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(con != null) {
				con.close();
			}
			System.out.println("Database Connection Close Success");
		} catch (SQLException e) {
			System.out.println("Connection Close Error");
		}
		
	} catch (SQLException | ClassNotFoundException e) {
		out.print("Database Error : " + e.getMessage());
	}
%>
</body>
</html>
