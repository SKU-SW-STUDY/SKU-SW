<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Table Select</title>
</head>
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
<body>
<%
	String id = "root";
	String pw = "XXXXXXXX";		
	String driver = "com.mysql.cj.jdbc.Driver";
	String jdbcURL = "jdbc:mysql://localhost:3306/gisa"; 
	Connection con = null;
	String table = request.getParameter("table") == null ? "gisa" : request.getParameter("table");
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(jdbcURL, id, pw);
		System.out.println("Database Connection Success");
		
		Statement stmt = null;
		ResultSet rs = null;
		
		stmt = con.createStatement();
		String sql = "select * from "+table+" limit 10";
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData metaData = rs.getMetaData();	// 테이블의 메타 데이터 정보 가져오기 
		int columnCount = metaData.getColumnCount();	// 테이블의 데이터 컬럼수 가져오기 
		
		out.print("<table>");
		out.print("<tr>");
		
		for(int i=1; i<=columnCount; i++){	/* 테이블 헤더를 구성 */
			String columnName = metaData.getColumnName(i);
			out.print("<td>"+columnName+"</td>");
		}
		
		out.print("</tr>");
		
			while(rs.next()){
				out.print("<tr>");		
				for (int i = 1; i <= columnCount; i++) {
					Object columnValue = rs.getObject(i);
					out.print("<td>"+columnValue+"</td>");
				}
				out.print("</tr>");
			}
			
		out.print("</table>");	
		
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
