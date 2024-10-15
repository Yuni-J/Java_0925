package day11;

import java.util.Calendar;

/* 디자인 패턴
 * https://refactoring.guru/ko/design-patterns/what-is-pattern 여기에 설명이 잘 되어있음
 * 면접에도 나올수도 있음. 자세히 알아두는것도 좋음 -> 패턴의 종류, 뜻...
 * */

public class Singleton01 {

	public static void main(String[] args) {
		/* 디자인 패턴 : 개발자들이 개발 과정에서 하나의 패턴으로 묶어놓은 코드 조합
		 * 디자인 패턴 중 하나
		 * 싱글톤 : 단 1개만 존재해야하는 객체를 생성하여 => 공유하고자 할 때 사용
		 * */ 
		
		//Singetom 객체 생성
//		Singeton s = new Singeton();  //생성자가 private라서 생성이 안됨.
		// static 메서드/멤버변수는 클래스명으로 부터 바로 접근
		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		// 주소가 같다 => 하나의 객체를 공유 
		System.out.println(s);
		System.out.println(s1);
		
		// 싱글턴 예시 -> Calendar
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);
				
	}

}

class Singleton{
	
	// 단 1개만 존재하기 위해 객체의 인스턴스 생성 (공유)
	private static Singleton instance;
	//생성자를 통해 객체 생성을 막기위해 생성자를 private 설정
	private Singleton() {}
	
	//getInstance() 메서드를 사용하여 instance를 생성해서 리턴
	//instance가 있으면 기존 instance를 리턴
	//instance가 없으며 새로 생성해서 리턴
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;		
	}
	
}
