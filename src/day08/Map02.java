package day08;

import java.util.HashMap;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/* 과목과 점수를 입력받아(Scaner) map에 저장 후 출력
		 * 합계, 평균 출력
		 * 종료 키워드가 나올 때까지 반복 (1=계속, 0=종료)
		 * 과목/점수 입력 > 국어 78
		 * (1=계속, 0=종료) > 1
		 * 영어 98
		 * ... 반복
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		int sum = 0;
		int menu = 0;
		
		do {
			System.out.println("1 => 계속, 0 => 종료");
			System.out.println("선택 >");
			menu = scan.nextInt();
			switch(menu) {
			case 1: 
				System.out.println("과목 / 점수 입력 >");
				String subject = scan.next();
				int score = scan.nextInt();
				map.put(subject, score);
				break;
			case 0: System.out.println("종료!"); break;
			default: System.out.println("잘못된 선택입니다.");
			}
	
		}while(menu != 0);
		
		for(String k : map.keySet()) {
			sum += map.get(k);
			System.out.println(k+":"+map.get(k));
		}
		System.out.println("합계:"+sum+", 평균:"+(sum/map.size()));
		
		scan.close();
	}

}
