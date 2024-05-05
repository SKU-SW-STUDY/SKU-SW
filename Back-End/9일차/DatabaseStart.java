package sku.lesson.db;

public class DatabaseStart {

	public static void main(String[] args) {
		DatabaseStart st = new DatabaseStart();
		st.testQuery();

	}
	
	public void testQuery() {
		BookDAO dao = new BookDAO();
		dao.select("select * from book;");
	}

}
