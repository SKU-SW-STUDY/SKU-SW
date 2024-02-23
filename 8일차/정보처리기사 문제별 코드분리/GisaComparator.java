package basic.Lesson.gisa;

import java.util.Comparator;

public class GisaComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int result = 0;
		result = (o2.getE_score()+o2.getK_score()) - (o1.getE_score()+o1.getK_score());
		if(result==0){
			result = o1.getStdNo() - o2.getStdNo();
		}
		return result;
	}

}
