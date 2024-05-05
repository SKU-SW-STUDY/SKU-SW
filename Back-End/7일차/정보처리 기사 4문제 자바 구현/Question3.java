import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Question3 {
	
public static void question3() throws IOException {
		
		/* *
		 * 3. (영어점수 + 수학점수)가 120점 이상인 자료의 (총점 + 점수포인트) 합을 출력하시오
		 */
		String filePath = "C:\\Users\\admin\\Desktop\\실습파일\\Abc1115.txt";
		// 1. 학번 2. 이메일 3. 국어 4. 영어 5. 수학 6. 과학 7. 국사 8. 총점 9. 담임코드 10. 성취도 11. 지역코드
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		ArrayList<Student> list = new ArrayList<Student>();
		String str;     
		
		try {
			while ((str = reader.readLine()) != null) {
				Student stu = new Student();
				stu.num = str.substring(0, 6);
				stu.email = str.substring(6,10);
				stu.korea = str.substring(11,13);
				stu.english = str.substring(14, 16);
				stu.math = str.substring(17, 19);
				stu.sience = str.substring(20, 22);
				stu.history = str.substring(23, 25);
				stu.total = str.substring(25, 28);
				stu.code = str.substring(28, 29);
				stu.good = str.substring(29, 30);
				stu.regionCode = str.substring(30, 31);
				stu.compareNum = Integer.parseInt(stu.english.trim()) +Integer.parseInt(stu.math.trim());
				
				if(stu.compareNum > 120) list.add(stu);
			}

			for(int i=0; i<list.size(); i++) {
				Student st1 = list.get(i);
				int sum = 0;
				
				if("A".equals(st1.good)) sum+=5;
				else if("B".equals(st1.good)) sum +=15;
				else sum += 20;
				
				System.out.println("학번:"+st1.num + ", 총점 합계:"+(st1.compareNum + sum));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
	}

}
