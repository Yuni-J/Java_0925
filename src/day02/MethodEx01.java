package day02;

import java.util.Scanner;

public class MethodEx01 {
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
		return num2 != 0 ? num1 / (double) num2 : -99999.0;
	}
	public int rem(int num1, int num2) {
		return num2 != 0 ? num1 % num2 : -99999;
	}
	
	public static void main(String[] args) {
		/* 계산기 만들기
		 * --menu--
		 * 1.덧셈|2.뺄셈|3.곱셈|4.나눗셈|5.나머지|6.종료
		 * > 메뉴선택 1
		 * > 숫자입력 : 1 5
		 * 결과 : 1 + 5 = 6
		 * (더하기 메서드를 호출하여 연산결과를 출력)
		 * */
		
		Scanner sc = new Scanner(System.in);
		MethodEx01 m = new MethodEx01();
		//기존에 다른 클래스에서 만들어놓은 메서드 호출
		Method02 m2 = new Method02(); 
		
		int menu = 0;
		int num1 = 0;
		int num2 = 0;
		
		do {
			System.out.println("--menu--");
			System.out.println("1.덧셈|2.뺄셈|3.곱셈|4.나눗셈|5.나머지|6.종료");
			System.out.println("menu >> ");			
			menu = sc.nextInt();
			System.out.println("menu : "+ menu);		

			if(menu < 6) {
				System.out.println("두 숫자를 입력하시오.");
				num1 = sc.nextInt();
				num2 = sc.nextInt();			
			}

			switch (menu) {
			    case 1: 
			        System.out.println(num1 + " + " + num2 + " = " + m2.sum(num1, num2)); 
			        break;
			    case 2: 
			        System.out.println(num1 + " - " + num2 + " = " + m.sub(num1, num2)); 
			        break;
			    case 3: 
			        System.out.println(num1 + " × " + num2 + " = " + m.mul(num1, num2)); 
			        break;
			    case 4: 
			    	double resultD = m.div(num1, num2);
			    	if(resultD != -99999.0) {
			    		System.out.println(num1 + " ÷ " + num2 + " = " + resultD); 			    		
			    	} else {
			    		System.out.println("error!! 0으로 나눌 수 없습니다.");
			    	}
			        break;
			    case 5: 
			    	int resultR = m.rem(num1, num2);
			    	if(resultR != -99999) {
			    		System.out.println(num1 + " % " + num2 + " = " + resultR); 			    		
			    	} else {
			    		System.out.println("error!! 0으로 나눌 수 없습니다.");
			    	}
			        break;
			    case 6: 
			        System.out.println("bye!!"); 
			        break;
			    default: 
			        System.out.println("잘못된 메뉴입니다.");
			}
		} while(menu != 6); 
		
		System.out.println("종료!");
			
		sc.close();
		
	}

}
