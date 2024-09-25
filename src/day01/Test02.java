package day01;

public class Test02 {

	public static void main(String[] args) {
		/* 국어 영어 수학 세 점수의 합계와 평균을 출력
		 * if 문 이용하여 평균 80점이상이면 pass / fail 
		 */
		int kor = 78;
		int eng = 83;
		int math = 91;
		
		int sum = kor + eng + math;
		double avg = sum / 3;
		System.out.println("합계 : " + sum + " / 평균 : " + avg);
		
		if(avg >= 80) {
			System.out.println("결과 : pass");
		}else {
			System.out.println("결과 : fail");
		}	
	}

}
