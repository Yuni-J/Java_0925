package day02;

public class Method02 {

	public static void main(String[] args) {
		// 사칙연산 ( + -  * / % ) 각각의 메서드 생성
		Method02 m = new Method02();
		System.out.println("sum : " + m.sum(100, 10));
		System.out.println("sub : " + m.sub(100, 10));
		System.out.println("mul : " + m.mul(100, 10));
		System.out.println("div : " + m.div(100, 10));
		System.out.println("rem : " + m.rem(100, 10));
		// div, mod => 나누는 값이(num2)가 0이면 Exception 발생
		// return 타입이 double Infinity
		// method에서 return은 메서드의 종료를 알림.
		double result = m.div(5, 0);
		if(result != -99999.0) {
			System.out.println(result);
		}
		
		int result2 = m.rem(5, 0);
		if(result2 == -99999) {
			System.out.println("rem : 0으로 나눌 수 없습니다.");
		} else {
			System.out.println(result2);
		}
	}
	// sum, sub, mul, div, rem
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
	public int sub(int num1, int num2) {
		return num1 - num2;
	}
	public int mul(int num1, int num2) {
		return num1 * num2;
	}
	public double div(int num1, int num2) {
		if(num2 == 0) {
			System.out.println("div : 0으로 나눌 수 없습니다.");
			return -99999.0;
		} else {
			return num1 / (double)num2;			
		}
	}
	public int rem(int num1, int num2) {
		if(num2 != 0) {
			return num1 % num2;			
		} else {
			return -99999;
		}
	}
}
