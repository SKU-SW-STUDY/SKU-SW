package basic.Lesson.gisa;

import java.util.ArrayList;

public class Solution {
	
	public String solveQuestion1(ArrayList<Student> list) {
		String answer = null;
		System.out.println("Question1 문제풀이");
		
		return answer;
	}
	
	public String solveQuestion2(ArrayList<Student> list) {
		String answer = null;
		// 지역코드가 B인 자료에 대하여 (국어점수 + 영어점수) 중 가장 큰값 구하기
		// ArrayList 지식
		// max 알고리즘
		// 기본 문법 (변수, 제어문)
		
		int max = 0;
		int sum = 0;
		System.out.println("Question2 문제풀이");
		
		for(int i=0; i<list.size();i++) {
			if("B".equals(list.get(i).getRegion_code())) {
				sum = list.get(i).getK_score() + list.get(i).getE_score();
			
				if(sum > max) max = sum;
			}
		}
		answer = String.valueOf(max);
		return answer;
	}
	
	public void solveQuestion3(ArrayList<Student> list) {
		//String answer = null;
		// 성취도 점수 A : 5, B : 15, C : 20 으로 환산하여 (영어점수 + 수학점수)가 120점 이상인 
		// 자료의 (총점 + 점수포인트) 합계를 출력하시오
		
		int sum = 0;
		int result = 0;
		
		for(Student st : list) {
			sum = st.getE_score() + st.getM_score();
			if(sum > 120) {
				if("A".equals(st.getGood_code())) {
					result += 5;
				}else if("B".equals(st.getGood_code())) {
					result += 15;
				}else {
					result += 20;
				}
				
				System.out.println("학번 : "+st.getStdNo()+", 총점 : "+(result+st.getTotal_score()));
			}
		}
	}

}
