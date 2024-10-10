package sale_1010;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		// 키오스크 
		/* menu
		 * 1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)|
		 * 4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)|
		 * 7.전체 판매 내역|8.종료
		 * */
		
		Scanner scan = new Scanner(System.in);
		SaleController sc = new SaleController();
		int menu = 0;
		
		do {
			System.out.println("1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)|"
					+ "4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)|"
					+ "7.전체 판매 내역|8.종료");
			System.out.print("메뉴 선택  > ");
			menu = scan.nextInt();
			switch(menu) {
			case 1: sc.addMenu(scan); break;
			case 2: sc.removeMenu(scan); break;
			case 3: sc.modifyMenu(scan); break;
			case 4: sc.totalMenuView(); break;
			case 5: sc.menuOrder(scan); break;
			case 6: sc.receiptPrint(); break;
			case 7: sc.totalSale(); break;
			case 8: System.out.println("종료!"); break;
			default: System.out.println("메뉴에 없는 선택지입니다.");
			}
		} while(menu != 8);

		scan.close();
	}

}
