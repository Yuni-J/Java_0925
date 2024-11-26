package sale_1010;
/* SaleController Class
 * : Menu List/Order List
 * Menu List => List<Menu> menu = new ArrayList<>();
 * Order List => List<Order> order = new ArrayList<>();
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SaleController {
	List<Menu> menu = new ArrayList<>();
	List<Order> order = new ArrayList<>();

	
	public void originMenu(){
		// 기본 메뉴 추가 메서드
		menu.add(new Menu("001","햄버거",5000));
		menu.add(new Menu("002","감자튀김",2500));
		menu.add(new Menu("003","콜라",2000));
	}

	public void addMenu(Scanner scan) {
		// 1.메뉴추가
		System.out.println("메뉴를 추가해주세요");
		System.out.print("제품번호	> ");
		String productID = scan.next();
		System.out.print("제품명	> ");
		String productName = scan.next();
		System.out.print("가격	> ");
		int price = scan.nextInt();
	
		menu.add(new Menu(productID,productName, price));
		System.out.println("메뉴가 추가되었습니다.");
		System.out.println();
	}

	public void removeMenu(Scanner scan) {
		// 2.메뉴삭제 : remove(index)
		// remove(Object) : 하나의 객체 요소로 그 객체가 전체 일치라고 볼 수 없
		// equals 명령어 자체를 수정하면 가능
		System.out.println("삭제할 메뉴를 입력해주세요");
		System.out.print("제품명  > ");
		String menuName = scan.next();
		int index = -1;
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).getproductName().equals(menuName)) {
				index = i;
				break;
			}
		}
		menu.remove(index);
		System.out.println("메뉴가 삭제되었습니다.");			
		
		if(index == -1) {
			System.out.println("삭제할 메뉴가 없습니다.");
			return;
		}
	}

	public void modifyMenu(Scanner scan) {
		// 3.메뉴수정(가격수정) 
		System.out.println("수정할 메뉴를 입력해주세요");
		System.out.print("제품명  > ");
		String menuName = scan.next();
		
		for(Menu temp : menu) {
			if(temp.getproductName().equals(menuName)) {
				System.out.print("수정할 가격을 입력하세요  > ");
				int newPrice = scan.nextInt();
				temp.setPrice(newPrice);
				System.out.println("메뉴가 수정되었습니다.");
			}
		}
	}

	public void totalMenuView() {
		// 4.메뉴보기(전체메뉴보기)
		System.out.println("--전체 Menu--");
		for(Menu temp : menu) {
			System.out.println(temp);
		}
		System.out.println("------------");
	}

	public void menuOrder(Scanner scan) {
		// 5.주문
		System.out.println("주문할 메뉴를 선택하세요");
		while(true) {
			System.out.print("주문번호	> ");
			int orderNum = scan.nextInt();
			System.out.print("제품명	> ");
			String menuName = scan.next();
			System.out.print("수량	> ");
			int amount = scan.nextInt();
			
			Menu selectMenu = null;
			for(Menu temp : menu) {
				if(temp.getproductName().equals(menuName)) {
					selectMenu = temp;
					break;
				}
			}
			if(selectMenu == null) {
				System.out.println("없는 메뉴입니다.");
				return;
			} 
				String id = selectMenu.getProductID();
				int price = selectMenu.getPrice();
				int payment = price * amount;
				order.add(new Order(orderNum, id, menuName, price, amount, payment));
				System.out.println("주문이 완료되었습니다.");
				System.out.println();
		
			
			System.out.println("주문을 더 하시겠습니까? (예=1 / 아니오=0)  >");
			int goOrder = scan.nextInt();
			if(goOrder == 0) {
				break; //주문 종료
			}
		}
	}
	
	public void receiptPrint(Scanner scan) {
		// 6.주문내역출력(영수증)
		System.out.println("주문번호를 입력해주세요(전체=0)  > ");
		int orderNumber = scan.nextInt();
		System.out.println("--주문내역출력--");
		for(Order temp : order) {
			if(temp.getOrderNum() == orderNumber) {
					System.out.println(temp);
			}
		}
		System.out.println("--------------");
		if(orderNumber == 0) {
			for(Order temp : order) {
				System.out.println(temp);
			}
		}
	}
	
	public void totalSale() {
		// 7.전체 판매 내역
//		System.out.println("--전체 판매 내역--");
//		
//		int total = 0;
//		for(Order temp : order) {
//			System.out.println("제품명:"+temp.getproductName()
//			+", 수량:"+temp.getAmount()+", 가격:"+temp.getPayment());
//		total += temp.getPayment();
//		}
//
//		System.out.println("---------------");
//	    System.out.println("총 판매 금액: " + total);
System.out.println("--전체 판매 내역--");
	    
	    Map<String, int[]> salesMap = new HashMap<>(); // 제품명, [수량, 총금액]
	    
	    for (Order temp : order) {
	        String productName = temp.getproductName();
	        int amount = temp.getAmount();
	        int payment = temp.getPayment();
	        
	        if (salesMap.containsKey(productName)) {
	            // 이미 제품명이 존재하는 경우 수량과 금액을 업데이트
	            int[] existing = salesMap.get(productName);
	            existing[0] += amount; // 수량 추가
	            existing[1] += payment; // 금액 추가
	        } else {
	            // 새로운 제품명인 경우 새로 추가
	            salesMap.put(productName, new int[]{amount, payment});
	        }
	    }

	    int total = 0; // 총 판매 금액

	    for (Map.Entry<String, int[]> entry : salesMap.entrySet()) {
	        String productName = entry.getKey();
	        int[] values = entry.getValue();
	        int amount = values[0];
	        int payment = values[1];

	        System.out.println("제품명: "+productName+", 수량: "+amount+", 가격: "+payment);
	        total += payment;
	    }

	    System.out.println("---------------");
	    System.out.println("총 판매 금액: " + total);
		
	}


}
