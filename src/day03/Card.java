package day03;

/* 1장의 카드를 생성하기 위한 클래스
 * - 숫자 : 1~13 => 1(A) 11(j) 12(Q) 13(K)
 * - 모양 : ♥ ♣ ◆ ♠
 * - 한장의 카드를 출력하는 print() => ♥A ◆3
 * - ♣1 => ♣A / ♣11 => ♣J / ♣12 => ♣Q / ♣13 => ♣K
 * - #1 => ♥A / #25 => ♥A / ♣15 => ♣A◆
 * */
/* 클래스 구성
 * - 맴버변수 : 모양(shape), 숫자(num) => private getter/setter
 * - 메서드 : print()
 * - 생성자 : 기본생성자만 생성 => ♥A
 * - setShape() / setNum() : 설정할 수 있는 숫자와 모양을 제한
 * */

public class Card {
	private String shape;
	private int num;
	
	//생성자
	public Card() {
		this.shape = "♥";
		this.num = 1;
	}
	
	//print()
	public void print() {
		// 숫자 : 1~13 => 1(A) 11(j) 12(Q) 13(K)
		String cardValue;
		if(num>=2 && num<=10) {
			System.out.print(shape+num+" ");
		} else {
			switch(num) {
			case 1: 
				cardValue ="A"; break;
			case 11: 
				cardValue ="J"; break;
			case 12: 
				cardValue ="Q"; break;
			case 13: 
				cardValue ="K"; break;
			default: 
				cardValue ="A";
			}
			System.out.print(shape+cardValue+" ");
		}
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		// 모양 : ♥ ♣ ◆ ♠
		switch(shape) {
		case "♥": case "♣": case "◆": case "♠":	
			this.shape = shape;
			break; 
		default:
			this.shape = "♥";
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;			
	}


	
}
