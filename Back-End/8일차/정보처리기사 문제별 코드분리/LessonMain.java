package basic.Lesson.gisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		// 데이터 파일 생성
		ArrayList<Student> list = this.makeData();
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
	
	 public ArrayList<Student> makeData(){	// 데이터를 File 에 읽어서 전달!
		 ArrayList<Student> list = null;
		 // 파일 연결
		 File file = new File("Abc1115.csv"); // 현재경로는 최상위 프로젝트 경로로 지정
		 try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			list = new ArrayList<Student>();
			// 파일 안의 1000개의 라인에 각각 접근하여 --> 스트림 처리(IO) 
			while((line=br.readLine())!= null) {
				// 각라인을 11개의 데이터로 분리하여 --> String 분리
				String[] tmp = line.split(",");
				
				// Student객체로 생성한 다음 List에 저장 --> ArrayList
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
