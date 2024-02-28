package sku.lesson.db.try1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LessonMain {

	public static void main(String[] args) {
		LessonMain l = new LessonMain();
		l.startLesson();
		
	}
	
	public void startLesson() {
		System.out.println("start Lesson");
		this.testStart();
	}
	
	public void testStart() {
		JDBCMain m = new JDBCMain();
		// 데이터 파일 생성
		ArrayList<Student> list = m.makeDataSQL();
		// 로직클래스에게 데이터 전달
		Solution solution = new Solution();
		// 정답받아서 답안지 작성 
		
		String answer = solution.solveQuestion1(list);
		this.writeAnswer(1, answer);
		
		answer = solution.solveQuestion2(list);		
		this.writeAnswer(2, answer);
		
		answer = solution.solveQuestion3(list);
		this.writeAnswer(3, answer);
		
		answer = solution.solveQuestion4(list);
		this.writeAnswer(4, answer);
		
	}
	 
	 public void writeAnswer(int number, String answer) { // 정답을 받아서 답안지 작성
		 System.out.println(number+"번 문제 답:" + answer);
		 // 파일 생성
		 File file = new File("Ans"+number+".txt");
		 // 파일 접근
		 FileWriter fw;
		 
		 try {
			// 파일 쓰기
			fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(answer);
			 
			pw.close();
			fw.close();
		 }catch (IOException e) {
			 System.out.println("writeAnswer() IO Exception : "+e.getMessage());
			 e.printStackTrace();
		 } 
	 }

}
