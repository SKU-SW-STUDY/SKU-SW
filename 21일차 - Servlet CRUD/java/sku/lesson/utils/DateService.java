package sku.lesson.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
	
	public static String getDateTime(int type) {
		String now = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now = sdf.format(new Date());
		if(type == 1) {
			now = now.split(" ")[0];
		} else if(type == 2) {
			now = now.split(" ")[1];
		}
		return now;
	}

}
