package sku.lesson.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LessonMain {

	public static void main(String[] args) {
		LessonMain m = new LessonMain();
		m.testStart();
	}
	
	public void testStart() {
		GisaDAO dao = new GisaDAO();
		
		String quiz1Query = "select std_no as answer from gisa where loc_code = 'B' order by (kor + eng) desc, std_no asc limit 4, 1;";
		
		String quiz2Query = "select max(kor + eng) as answer from gisa where loc_code = 'B';";
		
		StringBuilder quiz3Query = new StringBuilder("select sum(total) + ");
		quiz3Query.append("sum(case when acc_code = 'A' then 5 when acc_code = 'B' then 15 when acc_code = 'C' then 20 end)");
		quiz3Query.append("as answer from gisa where (eng+math) >=120;");
		
		StringBuilder quiz4Query = new StringBuilder("select count(*) as answer from gisa ");
		quiz4Query.append("where acc_code in('A', 'B') and ");
		quiz4Query.append("kor + (case when loc_code = 'A' then 5 when loc_code = 'B' then 10 when loc_code = 'C' then 15 end) >= 50;");
		
		String answer = dao.quizSolve(quiz1Query);
		this.answerWriter(1, answer);
		
		answer = dao.quizSolve(quiz2Query);
		this.answerWriter(2, answer);
		
		answer = dao.quizSolve(quiz3Query.toString());
		this.answerWriter(3, answer);
		
		answer = dao.quizSolve(quiz4Query.toString());
		this.answerWriter(4, answer);
	}
	
	public void answerWriter(int num, String answer) {	/* 답안지 작성 함수 */
		try {
			File f = new File("Ans"+num+".txt");
			FileWriter fr = new FileWriter(f);
			
			fr.write(answer);
			fr.close();
			
			System.out.println(num+"번 문제 풀이 답:"+answer);
		} catch (IOException e) {
			System.out.println("File Write Error"+e.getMessage());
		}
	}
	
	public ArrayList<Student> makeListFromFile(){ /* 데이터 csv 파일에서 불러오는 함수 */
		ArrayList<Student> list = new ArrayList<Student>();
		
		try {
			File f = new File("Abc1115.csv");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				String []tmp = line.split(",");
				Student st = new Student(Integer.parseInt(tmp[0]), tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3])
						, Integer.parseInt(tmp[4]), Integer.parseInt(tmp[5]), Integer.parseInt(tmp[6]), Integer.parseInt(tmp[7])
						, tmp[8], tmp[9], tmp[10]);
				list.add(st);
			}
			
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("File Read Error: "+e.getMessage());
		}
		
		return list;
	}
	
	public void makeListData() {	/* 데이터 Insert 함수 */
		ArrayList<Student> list = this.makeListFromFile();
		GisaDAO dao = new GisaDAO();
		Boolean flag = dao.insert(list);
		
		if(flag) System.out.println("Success Insert");
		else System.out.println("Fail Insert");
	}

}
