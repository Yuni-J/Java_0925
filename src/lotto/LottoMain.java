//package lotto;
//
//import java.util.Scanner;
//
//public class LottoMain {
//	public static void main(String[] args) {
//		// 로또 프로그램
//		/* --menu--
//		 * 1. 로또 번호 생성 (수동) : 사용자가 직접 번호 입력
//		 * 2. 로또 번호 생성 (자동) : Random
//		 * 3. 당첨번호 입력 (수동, 자동) : 사용자가 직접 입력 -> 일단 오늘은 수동만
//		 * 4. 당첨확인 : 가장 마지막에 발행한 당첨번호로 확인
//		 * 5. 역대 당첨번호 목록 확인
//		 * 6. 종료
//		 * 
//		 * 로또는 상속을 하여 사용
//		 * Lotto class => 사용자의 번호를 저장하는 클래스  
//		 * -> 회차(첫 발행부터 자동 증가 1회차), 6자리 배열을 넣는 메서드(중복X), 출력
//		 * ex) 1회차 1 2 3 4 5 6
//		 * 
//		 * LottoExtend class => 당청번호 클래스 Lotto를 상속 + 보너스번호
//		 * ex) 1회차 1 2 3 4 5 6 [7]
//		 * 
//		 * LottoController => 처리
//		 * */
//		
//		// 당첨은 회차1번 사용자
//		
//		LottoController lc = new LottoController();
//		Scanner scan = new Scanner(System.in);
//		
//		int menu = 0;
//		
//		do {
//			System.out.println("1.수동로또번호|2.자동로또번호|3.당첨번호(수동)|4.당첨확인|5.로또회차|6.종료");
//			System.out.print("선택 >> ");
//			menu = scan.nextInt();
//			switch(menu) {
//			case 1: lc.UserLottoNumber(scan);
//				break;
//			case 2: lc.AutoLottoNumber();
//				break;
//			case 3: lc.LottoWinningNumber(scan);
//				break;
//			case 4: lc.LottoRank();
//				break;
//			case 5: lc.LottoRound();
//				break;
//			case 6: System.out.println("종료!");
//				break;
//			default: System.out.println("잘못된 메뉴입니다. 다시 선택하시오");
//			}
//		} while(menu != 6);
//		
//		scan.close();	
//	}
//
//}
