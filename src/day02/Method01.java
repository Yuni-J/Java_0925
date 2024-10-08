package day02;

public class Method01 {
	// 다른 메서드의 위치 공간 
	public static void main(String[] args) {
		/* 메서드(Method) : function 기능(함수)
		 * 
		 * 메서드 선언 및 구현 :
		 * 접근제한자(제어자) 리턴타입 메서드명(매개변수){
		 * 	기능구현;
		 * }
		 * 
		 * - 접근제한자(제어자) : 접근할 수 있는 주체의 제한범위
		 * - 리턴타입 : 리턴할 값의 타입(타입으로만 기재)
		 * - 메서드명 : 소문자로 시작
		 * - 매개변수 : 기능을 수행하기 위해 필요로 하는 값 (외부에서 들어와야 하는 값)
		 * - void : 리턴할 값이 없다면 것을 의미
		 * 
		 * - 메서드의 선언 위치
		 * - 클래스 안, 메서드 밖
		 * - 메서드의 선언 순서는 상관없음
		 * - 메서드는 순서대로 실행되는 것이 아니라 호출되어야 실행.
		 * - 메서드의 호출은 다른 메서드에서도 가능. 다른 클래스의 메서드에서도 가능. (접근권한만 된다면...)
		 * 
		 * - 접근 권한
		 * - public : 누구나 사용 가능(모두가능)
		 * - protected : 나 + 패키지 + 자식클래스 (상속을 위해서 사용)
		 * - (default) : 나 + 패키지
		 * - private : 나 
		 * -> private < default < protected < public 
		 * */
		
		int result = sum(10,20);
		System.out.println(result);
		
		// static이 없는 메서드는 객체 생성 후 호출
		Method01 m = new Method01();  // 내 클래스의 객체 생성 
		// Method01 클래스의 인스턴스를 생성하여 그 인스턴스를 m에 할당 -> m을 통해 Method01의 메서드에 접근할 수 있음
		m.sum2(100,200);
		
	}
	// 다른 메서드의 위치 공간
	// 두 정수의 값을 매개변수로 주고, 두 수의 합을 리턴하는 메서드
	// 리턴 타입 : 합 => int (정수)
	// 메서드명 : sum
	// 매개변수 : 두 정수 => int num1, int num2
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	// static 모든 사람이 쓸 수 있게 만듬 -> 어떤 상황에서도 공유하기 위해서 DB 상황에서 많이 사용 
	
	// static 보다 인스턴스 메서드 방식 추천
	// 리턴이 없는 타입
	public void sum2(int num1, int num2) {
		System.out.println(num1 + num2);
	}
}
