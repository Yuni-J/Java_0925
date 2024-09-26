package day02;

public class Method04 {

	public static void main(String[] args) {
		/* 메서드 오버로딩
		 * - 동일한 이름의 메서드를 여러개 만드는 케이스
		 * - 오버로딩의 조건
		 * 1. 매개변수의 개수가 달라야 함. 
		 * 2. 매개변수의 타입이 달라야 함.
		 * - 리턴타입은 상관없음. 매개변수의 이름도 상관없음.
		 * */
		
		/* 가변인자 메서드
		 * - ... 배열처럼 받을 수 있는 메서드
		 * - 매개변수의 개수가 고정되지 않은 경우 사용
		 * */
		
		
		Method04 m4 = new Method04();
		System.out.println(m4.sum(10, 20));
		System.out.println(m4.sum(10, 20, 30));
		System.out.println(m4.sum(10.5, 10));
		System.out.println(m4.sum(1,2,3,4,5,6,7,8,9));
		
//		Test1 t = new Test1();
//		t.print();
//		t.a = 5;
//		t.b = 3;
//		t.print();

	}
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
	public int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	public double sum(double num1, int num2) {
		return num1 + num2;
	}
	public int sum(int ...num) {  //num을 배열처럼 처리가능.
		int result = 0;
		for(int temp : num) {
			result += temp;
		}
		return result;
	}

}