package sku.lesson.service;

import java.util.ArrayList;

import sku.lesson.dao.StudentDAO;
import sku.lesson.dto.StudentDTO;

public class GisaService {
	
	public ArrayList<StudentDTO> getData(int i){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		StudentDAO sd = new StudentDAO();
		list = sd.select(i);
		return list;
	}
}
