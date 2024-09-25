package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		// 배열 : 같은 타입, 같은 의미를 가지는 변수들의 집합 (참조변수)
		// 타입 배열명[] = new int[개수];
		// 지역변수는 초기값이 없음. (-> 안정해주면 에러가 남.)
		// 참조변수는 초기값이 있음. (숫자는 0, 문자는 null)
		String s = new String("가나다라");
		// String 워낙 자주 사용하는 참조변수 => 일반 지역변수처럼 사용
		String s1 = "마바사아";
		System.out.println(s);
		System.out.println(s1);
		
//		int num;
//		num += 1;  //초기값이 없어서 Exception 발생
		
		int arr[] = new int[5];
		arr[0] += 1;
		System.out.println(arr[0]);
			
		// arr 배열에 숫자를 1, 2, 3, 4, 5 로 채우고 출력
		// arr.length = 총길이 -1 번지를 가지기 때문 => 총 5개 0 1 2 3 4
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.println(arr[i]);
		}
		
		System.out.println();
		arr[0] = 10;
		arr[1] = 20;
		System.out.println(arr);  // 주소로 나옴 
		System.out.println(arr[1]);
		
		
		System.out.println();
		/* 5자리 숫자를 입력받아서 각자리의 합을 출력
		 * 입력값 => 12345  출력 => 1+2+3+4+5 = ??
		 * 				   출력 => 5+4+3+2+1 = ??
		 * */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5자리의 숫자를 입력하시오.");
		int inputNum = sc.nextInt();
		int sum = 0;
		
		if(inputNum < 10000 || inputNum >= 99999) {
			System.out.println("5자리의 숫자를 입력해야 합니다.");
			sc.close();
			return;
		}
		int digitArr[] = new int[5];
		
		for(int i =0; i<digitArr.length; i++) {
			digitArr[i] = inputNum % 10;  // inputNum % 10을 해서 숫자 하나하나씩 추출한다.
			sum += digitArr[i];
			inputNum /= 10;
		}
		System.out.println("자릿수 배열 : " + Arrays.toString(digitArr));
		System.out.println("자릿수의 합 : " + sum);	
		
//		sc.close();
		
		
		//강사님 풀이
		
		System.out.println("숫자를 5자리 입력해주세요.");
		
		String iNum = sc.next();
		String number[] = iNum.split("");  // 갯수 상관이 없이 입력한 숫자가 배열로 리턴
		
		int arrSum = 0;
		
		for(int i=0; i<number.length-1; i++) {
			//String 연산 불가능.
			System.out.print(number[i]+" + ");
			//String => int 변환  Integer.parseInt(변환가능한 문자);
			arrSum += Integer.parseInt(number[i]);
		}
		arrSum += Integer.parseInt(number[number.length-1]);
		System.out.print(number[number.length-1]+ " = " + arrSum);
		System.out.println();  //줄바꿈
		
		for(int i=number.length-1; i>0; i--) {
			System.out.print(number[i]+" + ");
		}
		System.out.print(number[0]+" = "+ arrSum);
		
		sc.close();
		
	}

}
