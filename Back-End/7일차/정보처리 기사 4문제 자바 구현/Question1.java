import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Question1 {
	public static void question1() throws IOException {
		/* *
		 * 1. 지역코드가 B 인 자료에 대하여 (국어점수 + 영어점수)으로 내림차순 정렬했을때 5번째 학번 출력하시오. 동일값 발생시 학번에 대한 오름차순 정렬하시오. 
		 */
		String filePath = "C:\\Users\\admin\\Desktop\\실습파일\\Abc1115.txt";
		// 1. 학번 2. 이메일 3. 국어 4. 영어 5. 수학 6. 과학 7. 국사 8. 총점 9. 담임코드 10. 성취도 11. 지역코드
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		ArrayList<Student> list = new ArrayList<Student>();
		
		String str;     

		try {
			while ((str = reader.readLine()) != null) {
				String lastCharacter = str.substring(str.length() - 1);
				if("B".equals(lastCharacter)) {
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
					stu.compareNum = Integer.parseInt(stu.korea.trim()) +Integer.parseInt(stu.english.trim());
					
					list.add(stu);
					
				}
			}
			
			for(int i =0; i <list.size(); i++) {
				for(int j=i; j<list.size(); j++) {
					Student st1 = list.get(i);
					Student st2 = list.get(j);
					
					if(st1.compareNum < st2.compareNum) {
						list.set(i, st2);
						list.set(j, st1);
					}
					
					
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.close();
		}
		
	}
}
