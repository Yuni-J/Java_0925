package day09;

import java.util.Arrays;

public class Stream02 {

	public static void main(String[] args) {
		/* 배열에서 짝수만 출력(정렬) 중복되는 값이 있다면 제거
		 * */ 
		
		int[] arr = {1,8,5,4,9,6,3,1,2,4,7,8,5};

		Arrays.stream(arr)
		.filter(n -> n%2==0)
		.sorted()
		.distinct()
		.forEach(m -> System.out.print(m+" "));
//		.forEach(System.out::print);  //변수없이 print
		
		System.out.println();
		//배열로 리턴
		int[] result = Arrays.stream(arr)
				.filter(n -> n%2==1)
				.distinct()
				.sorted()
				.toArray();
		for(int temp : result) {
			System.out.print(temp+" ");
		}
		
		
	}

}
