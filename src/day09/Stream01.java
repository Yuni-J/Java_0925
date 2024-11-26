package day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Stream01 {
	
	public static void main(String[] args) {
		/* Stream(스트림)
		 * - 실제 입력(출력)되는 데이터의 흐름.
		 * - 파이프라인으로 데이터가 흘러가는 흐름의 개념
		 * - 스트림은 자료에 스트림을 생성하여 연산(복사본)
		 * - 스트림 연산은 연산을 다 수행하면 소모됨.(1회성)
		 * - 기존 자료를 복사하여 스트림을 구성하기 때문에 기존 자료의 
		 * 	 변경을 유발하지 않음.
		 * 
		 * - 스트림용 연산이 별도 존재
		 * - 중간연산, 최종연산으로 구분됨.
		 * - 중간연산 : 메서드를 이어서 사용할 수 있음.
		 * 	 distinct() : 중복제거 
		 *   filter() : 조건에 맞는 자료만 다음 스트림으로 이동
		 *   limit() : 스트림의 일부를 잘라냄
		 *   skip() : 스트림의 일부를 건너띔
		 *   sorted() : 정렬
		 *   map() : 새로운 형태로 변경
		 *   mapToInt() / mapToLong() / mapToObject
		 * 
		 * - 최종연산 : 스트림의 최종 결과 연산 (마지막에서만 가능)
		 *   forEach(), count(), sum(), allMatch() : 스트림요소가 전부 일치하는지...
		 *   anyMatch() : 하나라도 일치하는지...
		 *   toArray() : 배열로 변환
		 *   collect() : 스트립 수집
		 * */
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("--스트림을 이용한 합계--");
		
		int total = Arrays.stream(arr).sum();
		System.out.println(total);
		System.out.println("--스트림 count()--");
		//count() 연산은 return => Long
		long cnt = Arrays.stream(arr).count();
		System.out.println(cnt);
		
		//Optional : nullPointException 같은 Exceptiom을 처리할 수 있게 도와줌.
		System.out.println("--스트림 average()--");
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println(avg);
		
		//filter() : 조건
		//배열의 값 중 5이상만 출력
		System.out.println("--스트림 filter()--");
		Arrays.stream(arr).filter(n -> n>=5).forEach(m -> {
			System.out.print(m + " ");
		});
		System.out.println();
		
		//5이상의 합계 출력
		int sum2 = Arrays
				.stream(arr)
				.filter(n -> n>=5)
				.sum();
		System.out.println(sum2);
		
		System.out.println("-------------------------");
		int[] score = {78,89,86,58,74,51,63,89,90};
		//Stream을 이용하여 합계, 평균, 최대값
		int sumScore = Arrays.stream(score).sum();
		OptionalDouble avgScore = Arrays.stream(score).average();
		System.out.println("합계 : "+sumScore+", 평균 : "+avgScore);
		OptionalInt max = Arrays.stream(score).max();
		System.out.println("최대값 : "+max);
		
		//Stream을 이용하여 70점 이상의 인원수 출력
		Arrays.stream(score).filter(n -> n>=70).forEach(m ->{
			System.out.print(m+" ");
		});
		System.out.println();
		long cntScore = 
				Arrays.stream(score)
				.filter(n -> n>=70)
				.count();
		System.out.println("70점 이상 인원수 : "+cntScore);
		
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(1);
		list.add(5);
		list.add(1);
		list.add(4);
		
		System.out.println("--list stream 구성--");
		list.stream().forEach(n ->System.out.print(n+" "));
		System.out.println();
		
		System.out.println("--distinct() 중복제거--");
		list.stream()
		.distinct()
		.forEach(n -> System.out.print(n+" "));
		System.out.println();
		
		System.out.println("--sorted() 정렬--");
		list.stream()
		.sorted()
		.forEach(n->System.out.print(n+" "));
		System.out.println();
		
		// 합계 => intStream 에게만 존재
//		int s = list.stream().sum();  //error
		// map : 스트림 변화에 사용하는 중간연산
		// mapToInt : map 값을 int로 변환하는 역할
		int s = list.stream()
				.mapToInt(n->n.intValue())
				.sum();
		System.out.println("list 합계 :"+s);
		
		// 스트림 객체 생성
		System.out.println("--Stream 객체 생성--");
		Stream<Integer> s1 = Stream.of(10,20,30,40,50,60);
		
		int s2 = s1.mapToInt(n->n.intValue()).sum();
		System.out.println(s2);
				
		// 이미 소모된 스트림은 다시 사용할 수 없음. => error
		// 위의 list.stream()은 할때마다 복사본으로 만들어줘서 사용
		// 그래서 Stream 객채 생성은 별로 사용하지 않음 
//		OptionalDouble avgS1 = s1.mapToInt(n->n.intValue()).average();
//		System.out.println(avgS1);
		
	}

}
