package sku.practice.dbClient;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseClient {

	public static void main(String[] args) {
		DatabaseClient dc = new DatabaseClient();
		dc.testSelect();
	}
	
	public void testSelect() {
		String sql = "select std_no, email, total, mag_code from gisa limit 10";
		ClientDAO dao = new ClientDAO();
		ArrayList<HashMap<String, String>> list = dao.select(sql);
		this.printMap(list);
	}
	
	public void printMap(ArrayList<HashMap<String, String>> list) {
		for(HashMap<String, String> map : list) {
			System.out.println(map);
		}
	}

}
