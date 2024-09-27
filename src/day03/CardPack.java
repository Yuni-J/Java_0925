package day03;
/* 카드 한 묶음을 나타내는 클래스
 * ♥ ♣ ◆ ♠
 * ♥1~13 ♣1~13 ◆1~13 ♠1~13 => 52장의 카드로 구성
 * 52장의 카드를 담을 수 있는 배열 생성 (카드 한묶음 배열) 
 * 
 * 생성자 - 52장의 카드를 순서대로 생성되게 만들기.
 * 메서드 
 * - 카드 출력기능 : Card class => print() 사용
 * - 카드 초기화 기능 
 * - 카드 한장을 나눠주는 기능
 * - 카드를 섞는 기능
 * */

public class CardPack {
	private Card pack[] = new Card[52];
	private int count = 0;  // 카드의 index를 체크하기 위한 변수
	
	public CardPack() {
		// 52장의 카드를 생성하여 배열에 넣기
		// num 1~13 / shape ♥ ♣ ◆ ♠
		
		String[] shapes = {"♥", "♣", "◆", "♠"};
		
		for(String shape : shapes) {
			for(int j=1; j<=13; j++) {
				Card c = new Card();
				c.setShape(shape);
				c.setNum(j);
				pack[count] = c;  //카드 배열에 추가
				count++;
			}
		}
	}
	
	//카드를 섞는 기능
	// 리턴타입 : void 매개변수 : X
	// 랜덤번지를 하나 뽑아서 순서대로 0번지부터 교환
	public void mix() {
		for(int i=0; i<pack.length; i++) {
			int random = (int)(Math.random()*52);
			Card temp = pack[i];
			pack[i] = pack[random];
			pack[random] = temp;
		}
	}
	
	//카드 한장을 빼서 나눠주는 기능
	public Card pick() {
		if(count == 0) {
			return null;
		} else {
			count--;
			return pack[count];  //가장 마지막 번지
		}
	}
	
	//카드 초기화 기능
	public void init() {
		count = 52;
	}
	
	//카드 출력기능 : Card class => print() 사용
	public void cardAllPrint() {
		//카드 출력
//		for(Card card : pack) {
//			card.print();
//		}
		//모양별로 줄바꿈
		count = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				pack[count].print();
				count++;
			}
			System.out.println();
		}
	}

	public Card[] getPack() {
		return pack;
	}

	public void setPack(Card[] pack) {
		this.pack = pack;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
