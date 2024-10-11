package day09;

import java.util.ArrayList;
import java.util.Comparator;

public class Stream03 {

	public static void main(String[] args) {
		/* Student 클래스로 리스트 구성
		 * Student 이름, 점수만 가지는 클래스
		 * 
		 * 학생 5명을 추가하고, 콘솔에 출력
		 * 홍길동 : 80
		 * */ 
		
		ArrayList<Student03> list = new ArrayList<>();
		list.add(new Student03("홍길동",80));
		list.add(new Student03("박순이",76));
		list.add(new Student03("이기철",92));
		list.add(new Student03("최영이",84));
		list.add(new Student03("김철수",65));
		
		// 스트림을 이용하여 콘솔에 출력
		list.stream()
		.forEach(System.out::println);
		
		System.out.println("------------------");
		
		list.stream().forEach(n -> {
			String name = n.getName();
			int score = n.getScore();
			System.out.println(name+"=>"+score);
		});
		
		System.out.println("------------------");
		//list의 점수 합계 / 전체 인원수		
		int sum = 
				list.stream()
				.mapToInt(n->n.getScore())
				.sum();
		System.out.println("합계 : "+sum);
		long count = 
				list.stream()
				.count();
		System.out.println("전체 인원수 : "+count);
		
		System.out.println("------------------");
		//이름순으로 정력하여 출력
		
		list.stream()
		.sorted(new Comparator<Student03>() {
			@Override
			public int compare(Student03 o1, Student03 o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
				}
			})
		.forEach(System.out::println);
		
		
		

	}

}
