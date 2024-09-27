package day03;

public class Class03 {

	public static void main(String[] args) {
		
		Tv tv = new Tv();
		tv.power();
		tv.printTv();
		tv.setCh(17);
		tv.chUp();
		tv.chUp();
		tv.chUp();
		tv.chUp();
		tv.chUp();
		tv.chDown();
		tv.chDown();
		tv.chDown();
		tv.chDown();
		
		tv.volUp();
		tv.volUp();
		tv.volUp();
		tv.volDown();
		tv.volDown();
		tv.volDown();
		tv.volDown();
		tv.volZero();
		tv.printTv();
	}

}

// TV 클래스 생성
/* 맴버변수 : brand, power, ch, vol
 * 메서드 : 
 * power() 
 * chUp() / chDown() : 1씩 증가 20까지 있음. 20이 넘어가면 다시 0번으로 돌아오는 순환구조
 * volUp() / volDown() : 1씩 증감 10까지 있음. 10이 넘아가면 10, 0이면 음소거 출력
 * 음소거 메서드
 * */

// final : 변경할 수 없는 값을 지정 대문자로 쓰는 것을 원칙으로 함.
// get은 가능하나, set은 불가능
class Tv{
	private final String BRAND = "LG";
	private boolean power;
	private int ch;
	private int vol;
	
	//생성자 호출
	public Tv() {
		this.vol = 3;
	}
//	public Tv(String brand) {
//		this.brand = brand;
//	}
	
	
	public void printTv() {
		System.out.println("TV:" + BRAND +" | ch:"+ch+" | vol:"+vol);
	}
	
	public void power() {
//		this.power = !this.power;
		if(!power) {
			power = true;
			System.out.println("power : ON");
		} else {
			power = false;
			System.out.println("power : OFF");
		}
	}
	
	public void chUp() {
		if(power) {
			this.ch += 1;
			if(ch > 20) {
				this.ch = 1;
			}
			System.out.println("ch : " + ch);
		}
	}
	public void chDown() {
		if(power) {
			this.ch -= 1;
			if(ch <= 0) {
				this.ch = 20;
			}
			System.out.println("ch : " + ch);
		}
	}
	
	public void volUp() {
		if(power) {
			this.vol += 1;
			if(vol >= 10) {
				this.vol = 10;
			}
			System.out.println("vol : " + vol);
		}
	}
	public void volDown() {
		if(power) {
			this.vol -= 1;
			if(vol <= 0) {
				this.vol = 0;
			}
			System.out.println("vol : " + vol);
		}
	}
	public void volZero() {
		if(power) {
			this.vol = 0;
		}
		System.out.println("vol : zero");
	}

	public String getBrand() {
		return BRAND;
	}

//	public void setBrand(String brand) {
//		this.brand = brand;
//	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
	
}
