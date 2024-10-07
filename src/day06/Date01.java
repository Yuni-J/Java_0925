package day06;

import java.util.Calendar;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) {
		/* 날짜/시간 클래스
		 * Date 클래스 => Deprecated(비권장)
		 * Calendar 클래스 => Date 후속작. 추상클래스 => 객체를 생성할 수 없음.
		 * new 키워드로 객체 생성이 불가능.
		 * getInstance() 메서드를 이용하여 객체를 얻어 옴
		 * 
		 * */
		
		Date d = new Date();
		System.out.println(d);
//		d.getDate();
		
		Calendar c = Calendar.getInstance();  //오늘날짜
		System.out.println(c);
		System.out.println("--------------------");
		//month 0~11 -> +1 표현
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		// 일 = 1 ...
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		String weekString = "";
		switch(week) {
		case 1: weekString = "(일)"; break;
		case 2: weekString = "(월)"; break;
		case 3: weekString = "(화)"; break;
		case 4: weekString = "(수)"; break;
		case 5: weekString = "(목)"; break;
		case 6: weekString = "(금)"; break;
		case 7: weekString = "(토)"; break;
		}
		System.out.println(year+"-"+month+"-"+day);
		
		//2024-10-7(월) 오후 3:51
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int ampm = c.get(Calendar.AM_PM);
		String ampmString = "";
		if(ampm == 1) {
			ampmString = "오후";
		} else {
			ampmString = "오전";
		}
		System.out.println(year+"-"+month+"-"+day+weekString+" "+ampmString+" "+hour+":"+minute);
	}

}
