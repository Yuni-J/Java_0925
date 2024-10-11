package day09;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamEx01 {

	public static void main(String[] args) {
		/* 여행사 상품
		 * 여행비용이 15세 이상은 100만원, 미만은 50만원으로 계산
		 * 고객 5명이 패키지 여행을 떠난다고 했을 경우
		 * 1. 비용계산 => 출력
		 * 2. 고객 명단 출력
		 * 고객 클래스 생성하고, ArrayList로 고객관리
		 * 
		 * 예)
		 * 이름:이순신 나이:40 비용:100
		 * 이름:신사임당 나이:38 비용:100
		 * 이름:홍길동 나이:30 비용:100
		 * 이름:이짱구 나이:10 비용:50
		 * 이름:이짱아 나이:5 비용:50
		 * 총 여행경비 : xxx
		 * 
		 * 20세 이상 고객명단 => 이름순으로 정렬
		 * 이름:신사임당 나이:38 비용:100
		 * 이름:이순신 나이:40 비용:100
		 * 이름:홍길동 나이:30 비용:100
		 * */ 
		
		ArrayList<CustomerEx01> list = new ArrayList<>();
		list.add(new CustomerEx01("신형만",35));
		list.add(new CustomerEx01("봉미선",29));
		list.add(new CustomerEx01("신짱구",5));
		list.add(new CustomerEx01("신짱아",1));
		list.add(new CustomerEx01("흰둥이",8));
		
		list.stream().forEach(System.out::println);
		int cost = 
				list.stream()
				.mapToInt(n->n.getCost())
				.sum(); 
		System.out.println("총 여행경비 : "+cost);
		
		System.out.println("------------------");
		//20세 이상 고객명단 => 이름순으로 정렬
		System.out.println("--20세 이상 고객명단--");
		list.stream()
		.filter(n->n.getAge()>=20)
		.sorted(new Comparator<CustomerEx01>() {
			@Override
			public int compare(CustomerEx01 o1, CustomerEx01 o2) {
				return o1.getName().compareTo(o2.getName());
			}
		})
		.forEach(System.out::println);
		
	}

}
