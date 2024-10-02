package day04;

import java.util.Scanner;

/* Product 클래스 생성 : 상품을 등록하는 클래스
 * 상품명(name), 가격(price)을 맴버변수로생성
 * 상품을 추가 메서드
 * 상품출력 메서드 (toString 이용)
 * ex) 사탕 : 500
 * 과자 : 2000
 * 젤리 : 1000
 * */

class Product{
	private String[] name = new String[10];
	private String[] price = new String[10];
	private int count;
	
	//생성자
	public Product() {}
	public Product(String[] name, String[] price) {
		this.name = name;
		this.price = price;
	}


	//상품 추가 메서드
	public void insertProduct(String name, String price) {
		this.name[count] = name;
		this.price[count] = price;
		count++;
	}

	//상품 출력 메서드
	@Override
	public String toString() {
		String result = "";
		for(int i=0; i<count; i++) {
			result += "Product [상품=" + name[i] + " : 가격=" + price[i] + "원]\n";
		}
		return result;
	}
	
//	//상품 출력 메서드
//	@Override
//	public String toString() {
//		 StringBuilder sb = new StringBuilder();
//		    for (int i = 0; i < count; i++) {
//		        sb.append("Product [name=").append(name[i]).append(", price=").append(price[i]).append("]\n");
//		    }
//		    return sb.toString();
//	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
}

public class 과제0930 {

	public static void main(String[] args) {
		/* 상품 10개를 등록할 수 있는 배열 생성
		 * 스케너를 이용하여 상품 등록
		 * 등록한 상품을 출력
		 * 
		 * 상품을 등록하시겠습니까? (y/n) y => 등록, n => 스탑
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		Product p = new Product();
		
		String check="n";
		do {
			System.out.println("상품을 등록하시겠습니까? (y/n)");
			check = sc.next();
			if(check.equals("y")) {
				if(p.getCount() >= 10) {
					System.out.println("더이상 상품을 등록할 수 없습니다.");
					break;
				} 
				System.out.println("상품명 >>");
				String productName = sc.next();
				System.out.println("가격 >>");
				String productPrice = sc.next();
				
				p.insertProduct(productName, productPrice);
			} else if(check.equals("n")){
				System.out.println("나가겠습니다.");
			}
		} while(check.equals("y"));
		
		System.out.println("등록한 상품 : ");
	    System.out.println(p.toString());
		
		sc.close();
	}
}
