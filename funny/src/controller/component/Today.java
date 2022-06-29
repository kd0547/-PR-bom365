package controller.component;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Today {
	private String today;

	public Today() {
		//오늘날짜넣기
		 String pattern = "yyyy/MM/dd";
		 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		 today = sdf.format(new Date());
		 System.out.println(today);
	}
	
	public String today() {
		return today;
	}
	
}
