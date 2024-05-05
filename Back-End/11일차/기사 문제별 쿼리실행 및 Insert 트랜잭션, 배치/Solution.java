package sku.lesson.db.try1;

import java.util.ArrayList;
public class Solution {
	
	public String solveQuestion1(ArrayList<Student> list) {
		String answer = null;
		// 지역코드가 B인 자료에 대하여 (국어점수 + 영어점수)으로 내림차순 정렬했을 때 
		// 5번째 학번을 출력하시오. 동일값 발생시 학번에 대한 오름차순 정렬하시오.
		ArrayList<Student> result = new ArrayList<Student>();
		
		for(Student st : list) {
			if("B".equals(st.getRegion_code())){
				result.add(st);
			}
		}
		
		 for(int i=0; i<result.size(); i++) {
			for(int j=i; j<result.size(); j++) {
				Student s1 = result.get(i);
				Student s2 = result.get(j);
				
				int s1_sum = s1.getK_score() + s1.getE_score();
				int s2_sum = s2.getK_score() + s2.getE_score();
			
				if(s1_sum < s2_sum) {
					result.set(i, s2);
					result.set(j, s1);
				}else if(s1_sum == s2_sum){
					if(s1.getStdNo() > s2.getStdNo()) {
						result.set(i, s2);
						result.set(j, s1);	
					}
				}
				
			}
		}
		
		//result.sort(new GisaComparator()); // sort 함수에 comparator 인터페이스 구현한 클래스 생성후 전달 
		//printQuiz(result, 0, 5);
		answer = String.valueOf(result.get(4).getStdNo());
		return answer;
	}
	
	public void printQuiz(ArrayList<Student> list, int start, int end) {	/* 배열 출력함수 */
		for(int i = start; i < end; i++) {
			System.out.println(list.get(i));
		}
	}
	
	public String solveQuestion2(ArrayList<Student> list) {
		String answer = null;
		// 지역코드가 B인 자료에 대하여 (국어점수 + 영어점수) 중 가장 큰값 구하기
		// ArrayList 지식
		// max 알고리즘
		// 기본 문법 (변수, 제어문)
		int max = 0;
		int sum = 0;
		
		for(int i=0; i<list.size();i++) {
			if("B".equals(list.get(i).getRegion_code())) {
				sum = list.get(i).getK_score() + list.get(i).getE_score();
			
				if(sum > max) max = sum;
			}
		}
		answer = String.valueOf(max);
		return answer;
	}
	
	public String solveQuestion3(ArrayList<Student> list) {
		String answer = null;
		// 성취도 점수 A : 5, B : 15, C : 20 으로 환산하여 (영어점수 + 수학점수)가 120점 이상인 
		// 자료의 (총점 + 점수포인트) 합계를 출력하시오
		
		int sum = 0;
		int result = 0;
		
		for(Student st : list) {
			sum = st.getE_score() + st.getM_score();
			if(sum >= 120) {
				if("A".equals(st.getGood_code())) {
					result += 5;
				}else if("B".equals(st.getGood_code())) {
					result += 15;
				}else {
					result += 20;
				}
				result += st.getTotal_score();
			}
		}
		
		answer = String.valueOf(result);
		return answer;
	}
	
	public String solveQuestion4(ArrayList<Student> list) {
		String answer = null;
		// 지역코드 점수 A : 5, B : 10, C : 15 
		//성취도가 A, B인 자료에 대해 (국어점수 + 점수포인트)의 50 이상인 
		//자료의 건수를 출력하시오
		
		int sum=0;
		int count=0;
		for(Student st : list) {
			if(!"C".equals(st.getGood_code())){
				sum = st.getK_score();
			
				if("A".equals(st.getRegion_code()))sum += 5;
				else if("B".equals(st.getRegion_code()))sum += 10;
				else sum += 15;
			
				if(sum >= 50) count++;
			}
		}
		answer = String.valueOf(count);
		return answer;
	}

}
