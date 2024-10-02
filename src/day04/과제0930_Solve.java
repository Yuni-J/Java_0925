package day04;

import java.util.Scanner;

/* Product 클래스 생성 : 상품을 등록하는 클래스
 * 상품명(name), 가격(price) 을 멤버변수로 생성
 * 상품을 추가 메서드
 * 상품출력 메서드 (toString 이용) 
 * ex) 사탕 : 500
 * 과자 : 2000
 * 젤리 : 1000
 * */
class Product_Solve {
	private String name;
	private int price;
	
	//생성자
	public Product_Solve() {}
	public Product_Solve(String name, int price) {
		this.name = name;
		this.price = price;
	}
	//메서드 : 상품추가, toString
	public void insertProduct(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name + ":" + price+"원";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

public class 과제0930_Solve {

	public static void main(String[] args) {
		/* 상품 10개를 등록할 수 있는 배열 생성
		 * 스케너를 이용하여 상품 등록
		 * 등록한 상품을 출력
		 * 
		 * 상품을 등록하시겠습니까? (y/n) y=> 등록 / n=> 그만
		 * */
//		Product p = new Product("사탕", 500);
//		System.out.println(p);
//		p.insertProduct("젤리", 1000);
//		System.out.println(p);
		Scanner scan = new Scanner(System.in);
		
		Product_Solve[] p = new Product_Solve[10];
//		Product pro = new Product(); //1개의 객체를 변경해서 계속 배열에 추가 (연결링크만 복사됨.)
		
		char c = 'y'; //반복 키워드
		int cnt = 0; //index 변수
		
		while(c != 'n') {  // !(c.equals("n")) => String일 경우
			System.out.println("상품을 등록하시겠습니까? (y/n)");
			c = scan.next().charAt(0); // 1글자 입력
			if(c == 'y') {
				System.out.println("상품명>");
				String name = scan.next();
				System.out.println("가격>");
				int price = scan.nextInt();
				
				// 객체 생성 
				Product_Solve pro = new Product_Solve();
				pro.insertProduct(name, price); //추가 메서드 호출 
				p[cnt] = pro;
				cnt++;
				
			}else {
				if(c == 'n') {
					System.out.println("상품등록 종료!!");
				}else {
					System.out.println("y/n만 가능합니다.");
				}
			}
			
		}
		
		System.out.println("--등록된 상품 리스트--");
		for(int i=0; i<cnt; i++) {
			System.out.println(p[i]);
		}

		scan.close();
	}

}