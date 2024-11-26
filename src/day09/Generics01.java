package day09;

import java.util.ArrayList;
import java.util.List;

public class Generics01 {

	public static void main(String[] args) {
		/* 제너릭(Generics) : 데이터의 타입을 나중에 확정하는 기법
		 * 클래스나 메서드를 선언할 때 어떤 데이터가 올지 확신이 없다면,
		 * 제너릭 타입으로 구현 => 나중에 객체 생성시 타입을 확정하여 구현
		 * 
		 * 객체의 타입을 컴파일 할 때 체크할 수 있어서 안정성을 해치지 
		 * 않는 선에서 적당히 형변환이 가능한 기법
		 * 안정선 - 의도하지 않은 타입의 객체가 저장되는 것을 막는 것.
		 * */ 
		
		//객체 구현시 타입을 적어서 처리 (안써도 가능) 
		List<SaleGen01<Integer, String>> list = new ArrayList<>();
		int id = 1;
		String name = "햄버거";
		int price = 5000;
		
		SaleGen01<Integer, String> s = new SaleGen01<Integer, String>(id,name,price);
//		Sale s = new Sale(id,name,price); (생략가능)
		list.add(s);
		list.add(new SaleGen01(2, "콜라", 1500));
		int sum = 0;
		int idSum = 0;
		for(SaleGen01 t : list) {
			sum += t.getPrice();
			idSum += (int)t.getId();
			System.out.println(t);			
		}
		System.out.println("합계:"+sum);
		System.out.println("id합계:"+idSum);
	}

}
