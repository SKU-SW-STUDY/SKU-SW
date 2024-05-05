package sku.lesson.db.try1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCMain {

	public static void main(String[] args) throws SQLException {
		JDBCMain m = new JDBCMain();
		//m.testInsert();
		//m.testInsertStudent();
		m.testInsertArr();
		//m.testSelect();
		//m.testDelete();
	}

	public void testSelect() {
		String sql = "select * from gisa";
		GisaDAO dao = new GisaDAO();
		dao.select(sql);
	}
	
	public void testInsert() {
		String sql = "insert into gisa values (990001, 'addx', 17, 29, 16, 49, 43, 154, 'C', 'A', 'C');";
		GisaDAO dao = new GisaDAO();
		boolean flag = dao.insert(sql);
		if(flag) System.out.println("insert success");
		else System.out.println("insert fail");
	}
	
	public void testInsertStudent() {
		Student st = new Student(990001, "addx", 17, 29, 16, 49, 43, 154, "C", "A", "C");
		GisaDAO dao = new GisaDAO();
		boolean flag = dao.insert(st);
		if(flag) System.out.println("insert success");
		else System.out.println("insert fail");
	}
	
	public void testInsertArr() {
		GisaDAO dao = new GisaDAO();
		
		long startTime = System.currentTimeMillis();
		
		boolean flag = dao.insertNew(this.makeData());
		if(flag) System.out.println("insert success");
		else System.out.println("insert fail");
		
		long endTime = System.currentTimeMillis();
		
		long executionTime = endTime - startTime;
        System.out.println("실행 시간: " + executionTime + "밀리초");
	}
	
	public void testDelete() {
		String sql = "delete from gisa";
		GisaDAO dao = new GisaDAO();
		boolean flag = dao.delete(sql);
		if(flag) System.out.println("Delete success");
		else System.out.println("Delete fail");
	}
	
	 public ArrayList<Student> makeData(){	// 데이터를 File 에 읽어서 전달!
		 ArrayList<Student> list = null;
		 // 파일 연결
		 File file = new File("Abc1115.csv"); // 현재경로는 최상위 프로젝트 경로로 지정
		 try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			list = new ArrayList<Student>();
			
			while((line=br.readLine())!= null) {
				String[] tmp = line.split(",");
		
				Student st = new Student(Integer.parseInt(tmp[0].trim()), tmp[1], Integer.parseInt(tmp[2].trim()), 
						Integer.parseInt(tmp[3].trim()), Integer.parseInt(tmp[4].trim()), 
						Integer.parseInt(tmp[5].trim()), Integer.parseInt(tmp[6].trim()), 
						Integer.parseInt(tmp[7].trim()), tmp[8], tmp[9], tmp[10]);
				list.add(st);
			}
			
			br.close();
			fr.close();
			
		 }catch (FileNotFoundException e) {
			System.out.println("file not exists : "+e.getMessage());
			e.printStackTrace();
		 } catch (IOException e) {
			System.out.println("makeData() IO Exception : "+e.getMessage());
			e.printStackTrace();
		}
		 
		 return list;
	 }
	 
	 public ArrayList<Student> makeDataSQL(){
		 ArrayList<Student> list = null;
		 String sql = "select * from gisa";
		 GisaDAO dao = new GisaDAO();
		 list = dao.selectList(sql);
		 return list;
	 }

}
