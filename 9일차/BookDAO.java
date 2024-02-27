package sku.lesson.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO {
	
	public void select(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionManager.getConnection();
			stmt =  con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {	// 행처리 
				Book book = new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setBookName(rs.getString("bookname"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("Price"));
				
				/*SQL 의 인덱스는 1부터 시작, 타입도 맞춰줘야 한다. */
				System.out.println("rs:"+rs.getInt(1));	
				System.out.println("rs:"+rs.getString(2));
				System.out.println("rs:"+rs.getString(3));
				System.out.println("rs:"+rs.getInt(4));
				System.out.println(book);
			}
			
			ConnectionManager.connectionClose(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("select Error :"+e.getMessage());
		}
	}

}
