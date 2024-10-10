package sale_1010;
/* SaleController Class
 * : Menu List/Order List
 * Menu List => List<Menu> menu = new ArrayList<>();
 * Order List => List<Order> order = new ArrayList<>();
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleController {
	List<Menu> menu = new ArrayList<>();
	List<Order> order = new ArrayList<>();

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
		// 2.메뉴삭제
		System.out.println("삭제할 메뉴를 입력해주세요");
		System.out.print("제품명  > ");
		String menuName = scan.next();
		int index = -1;
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).getProdectName().equals(menuName)) {
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
			if(temp.getProdectName().equals(menuName)) {
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
		System.out.println("주문번호  > ");
		int orderNum = scan.nextInt();
		System.out.println("제품명  > ");
		String menuName = scan.next();
		System.out.println("수량  > ");
		int amount = scan.nextInt();
		
		 Menu selectMenu = null;
		for(Menu temp : menu) {
			if(temp.getProdectName().equals(menuName)) {
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

	}
	
	public void receiptPrint() {
		// 6.주문내역출력(영수증)
		System.out.println("--주문내역출력--");
		for(Order temp : order) {
			System.out.println(temp);
		}
		System.out.println("--------------");
	}
	
	public void totalSale() {
		// 7.전체 판매 내역
		
	}

}
