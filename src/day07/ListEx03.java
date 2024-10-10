package day07;

import java.util.ArrayList;
import java.util.List;

public class ListEx03 {

	public static void main(String[] args) {
		/* num의 값을 숫자 List를 생성하여 추가 => 출력
		 * 합계를 출력
		 * 70점 이상인 인원 수 출력
		 * => 3/8명
		 * */ 
		
		String num = "45,78,98,65,84,52,64,31";
		String[] numArr = num.split(",");
		
		// 문자를 숫자로 변환 후 리스트에 넣기
		List<String> score = new ArrayList<String>();
		
		for(String n : numArr) {
			score.add(n);
		}
		System.out.println(score);
		
		// 합계 출력 & 70점 이상인 인원 수 출력
		int sum = 0;
		int cnt = 0;
		for(String temp : score) {
			int s = Integer.parseInt(temp);
			sum += s;
			if(s>=70) {
				cnt++;
			}
		}
		System.out.println("합계 : "+ sum);
		System.out.println("70점 이상인 인원수 : "+cnt+"/"+score.size());
	}

}
