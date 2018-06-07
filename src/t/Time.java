package t;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// String time= sdf.format( new Date());
	// 这个字符串 time已经成为你要的格式了
	// 字符串变date
	// Date date=sdf.parse(time);
	
	public static void main(String[] args) {
		
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time= sdf.format( new Date());
		
		 System.out.println(time);
		 
		 try {
			Date date=sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
