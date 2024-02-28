package basic.lesson.db;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LessonMain {

	public static void main(String[] args) {
		LessonMain l = new LessonMain();
		l.testStart();

	}
	
	public void testStart() {	// 문제풀이를 실행할 함수 
		// 1. DAO 문제풀이 함수 쿼리 파라미터로 호출하기 
		// 2. 리턴받은 answer writeAnswer 함수로 작성하기 
		
		GisaDAO dao = new GisaDAO();
		
		String queryAnswer1 = "select std_no from gisa where loc_code = 'B' order by (kor + eng) desc, std_no asc limit 1 offset 4;";
		String queryAnswer2 = "select max(kor + eng) as maxScore from gisa where loc_code = 'B';";
		//String queryAnswer3 = "select total, acc_code from gisa where (eng + math) >= 120;";
		String queryAnswer3 = "select sum(total) + sum(case when acc_code='A' then 5 when acc_code='B' then 15 when acc_code='C' then 20 end) point from gisa where (eng + math) >= 120;";
		//String queryAnswer4 = "select kor, loc_code from gisa where acc_code in ('A', 'B');";
		StringBuilder queryAnswer4 = new StringBuilder("");
		queryAnswer4.append("select count(*) as cnt from gisa ");
		queryAnswer4.append("where acc_code in ('A', 'B') and ");
		queryAnswer4.append("(kor + (case when loc_code='A' then 5 when loc_code='B' then 10 when loc_code='C' then 15 end)) >= 50;");
		
		String answer = dao.selectQuiz1(queryAnswer1);
		this.writeAnswer(1, answer);
		
		answer = dao.selectQuiz2(queryAnswer2);
		this.writeAnswer(2, answer);
		
		answer = dao.selectQuiz3(queryAnswer3);
		this.writeAnswer(3, answer);
		
		answer = dao.selectQuiz4(queryAnswer4.toString());
		this.writeAnswer(4, answer);
	}
	
	public void writeAnswer(int index, String answer) {	// 문제풀이의 답안지를 작성할 함수 
		// 1. 파일 생성하기
		// 2. 파일에 답 작성하기
		// 3. 답안 작성후 종료(close)하기
		System.out.println(index+"번 문제 답:" + answer);
		// 파일 생성
		File file = new File("Ans"+index+".txt");
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
