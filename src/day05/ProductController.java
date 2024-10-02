package day05;

import java.util.Scanner;

public class ProductController {
//Product 배열 생성
//추가, 삭제, 수정, 리스트 보기  -> 스캐너 필요
	
	private Product[] menu = new Product[5];
	private int cnt;  //index 역할

	public ProductController() {}

	public void printProduct() {
		System.out.println("--등록된 상품 리스트--");
//		for(int i=0; i<cnt; i++) {
//			System.out.println("상품번호:"+i+" 제품명:"+menu[i].getName()+" | 가격:"+menu[i].getPrice());
//		}
//		System.out.println();
		for(int i=0; i<cnt; i++) {
			System.out.println(menu[i]);
		}
	}
	public void insertProduct(Scanner scan) {
//		if(cnt >= menu.length) {
//			System.out.println("더 이상 제품을 추가 할 수 없습니다.");
//			return;
//		}
//		System.out.println("제품명 >");
//		String name = scan.next();
//		System.out.println("가격 >");
//		int price = scan.nextInt();
//		scan.nextLine();
//		
//		Product p = new Product(name, price); 	
//		menu[cnt] = p;
//		cnt++;
//		System.out.println("제퓸이 등록되었습니다.");
//		System.out.println();
		
		//상품추가
		// 배열이 다 찼다면... 배열늘려주기.
		// 배열은 길이를 한번에 정하면 변경 불가능.
		// 더 긴 길이의 배열을 생성하여 배열 복사 후 배열 교체
		if(cnt == menu.length) {
			//5개 더 많은 길이의 배열을 생성
			Product[] temp = new Product[menu.length+5];
			//배열 복사
			System.arraycopy(menu, 0, temp, 0, cnt);  //기존 배열의 0번지부터 새배열의 0번지부터 cnt 개수만큼 복사
			menu = temp;
		}
		System.out.println("상품명 >");
		String name = scan.next();
		System.out.println("가격 >");
		int price = scan.nextInt();
		
		Product p = new Product();
		p.insertProduct(name, price);
		menu[cnt] = p;
		cnt++;
	}
	
	public void deleteProduct(Scanner scan) {
//		System.out.println("삭제할 상품번호를 입력하시오(0~"+(cnt-1)+") >");
//		int index = scan.nextInt();
//		scan.nextLine();
//		
//		if(index < 0 || index > cnt) {
//			System.out.println("없는 상품번호입니다.");
//			return;
//		}
//		for(int i=index; i<(cnt-1); i++) {
//			menu[i] = menu[i+1];
//		}
//		menu[cnt-1] = null;
//		cnt--;
//		System.out.println("상품이 삭제되었습니다.");
//		System.out.println();
		
		//상품삭제 : 이름을 검색하여 상품을 삭제 		
		System.out.println("삭제할 상품명 >");
		String deleteName = scan.next();
		int index = -1; //없는 번지를 기본값으로 설정
		for(int i=0; i<cnt; i++) {
			if(menu[i].getName().equals(deleteName)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			//deleteName을 못 찾았을 경우
			System.out.println("찾는 상품이 없습니다.");
			return;
		}
//		// 삭제 : 찾은 위치부터 뒷번지를 앞번지로 옮기는 작업
//		for(int i=index; i<cnt-1; i++) {
//			menu[i] = menu[i+1];  //덮어쓰기
//		}
		//arraycopy를 이용한 방법 => 속도가 빠름(성능이 우수)
		//기존 배열의 0번지부터 새배열의 0번지부터 cnt 개수만큼 복사
		int copyCnt = menu.length - index - 1;
		System.arraycopy(menu, index+1, menu, index, copyCnt);
		
		//끝번지는 null
		menu[cnt-1] = null;
		//한개의 상품이 줄어듬
		cnt--;
		printProduct();  //삭제 후 출력
		
	}
	
	public void modifyProduct(Scanner scan) {
//		System.out.println("수정할 상품번호를 입력하시오(0~"+(cnt-1)+") >");
//		int index = scan.nextInt();
//		scan.nextLine();
//		
//		System.out.println("수정할 제품명 >");
//		String newName = scan.next();
//		System.out.println("수정할 가격 >");
//		int newPrice = scan.nextInt();
//		scan.nextLine();
//		
//		Product newP = menu[index];
//		
//		newP.setName(newName);
//		newP.setPrice(newPrice);
//		System.out.println("제품이 수정되었습니다.");
//		System.out.println();
		
		//상품수정 : 이름을 검색하여 금액만 수정 
		System.out.println("수정할 상품명 >");
		String searchName = scan.next();
		for(int i=0; i<cnt; i++) {
			if(menu[i].getName().equals(searchName)) {
				System.out.println("수정 금액 >");
				int price = scan.nextInt();
				menu[i].setPrice(price);
				return;
			}
		}
		System.out.println("찾는 상품이 없습니다.");	
	}
	
	public Product[] getMenu() {
		return menu;
	}
	public void setMenu(Product[] menu) {
		this.menu = menu;
	}
}
