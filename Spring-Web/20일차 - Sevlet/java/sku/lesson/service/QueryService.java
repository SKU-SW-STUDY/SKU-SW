package sku.lesson.service;

import sku.lesson.dao.QueryDAO;

public class QueryService {
	
	public String[][] getData(String table){
		QueryDAO dao = new QueryDAO();
		String sql = "select * from "+table+" limit 5";
		String[] column = dao.getColumnNames(sql);
		String[][] data = dao.select(sql);
		
		String[][] result = new String[data.length+1][data[0].length];
		
		result[0] = column.clone();
		
		for(int i=1; i<data.length+1; i++) {
			result[i] = data[i-1].clone();
		}
		
		return result;
	}

}
