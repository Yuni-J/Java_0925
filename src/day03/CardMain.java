package day03;

public class CardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Card c = new Card();
		c.print();
		c.setShape("◆");
		c.setNum(5);
		c.print();
		c.setShape("♣");
		c.setNum(25);
		c.print();
		c.setShape("#");
		c.setNum(11);
		c.print();
		System.out.println();
		System.out.println("------------------");
		
		
		CardPack cp = new CardPack();
		cp.cardAllPrint();
		System.out.println("-----");
		
		//CardPack에서 cardAllPrint와 동일한 기능
		//cp.getPack() : CardPack의 멤버변수 배열 pack[]   pack[0] = cp.getPack()[0]
//		int count = 0;
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<13; j++) {
//				cp.getPack()[count].print();
//				count++;
//			}
//			System.out.println();
//		}
		 
		cp.mix();
		cp.cardAllPrint();
		
		System.out.println("------------------");
		System.out.println("딜러가 카드를 나누고 있습니다.");
		Card player1 = cp.pick();
		Card player2 = cp.pick();
		Card player3 = cp.pick();
		Card player4 = cp.pick();
		Card player5 = cp.pick();
		System.out.println("카드를 모두 나누었습니다.");
		System.out.print("player1 : ");
		player1.print();
		System.out.print("| player2 : ");
		player2.print();
		System.out.print("| player3 : ");
		player3.print();
		System.out.print("| player4 : ");
		player4.print();
		System.out.print("| player5 : ");
		player5.print();
		
		
		
		cp.init();
		cp.mix();
		
		System.out.println();
		System.out.println("------------------");
		System.out.println("딜러가 카드를 나누고 있습니다.");
		Card player1_1 = cp.pick();
		Card player2_1 = cp.pick();
		Card player3_1 = cp.pick();
		Card player4_1 = cp.pick();
		Card player5_1 = cp.pick();
		System.out.println("카드를 모두 나누었습니다.");
		System.out.print("player1 : ");
		player1_1.print();
		System.out.print("| player2 : ");
		player2_1.print();
		System.out.print("| player3 : ");
		player3_1.print();
		System.out.print("| player4 : ");
		player4_1.print();
		System.out.print("| player5 : ");
		player5_1.print();

				
	}

}
