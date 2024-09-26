package day02;

public class Class02 {

	public static void main(String[] args) {
		
		Car c = new Car();
		c.setName("소나타");
		c.setColor("검은색");
		c.setYear("2024");
		c.printCar();
		
		c.power();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.power();

	}

}

// Car 클래스 생성
// 맴버변수 : name, color, year, power, speed => private 선언 (getter/setter 생성)
// 소나타(블랙/2024) => 출력 메서드
// power : 시동 상태 나타내는 메서드 (true / false)
// speed : 속도 up / down 메서드

class Car{
	private String name;
	private String color;
	private String year;
	private boolean power;
	private int speed;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	public void printCar() {
		System.out.println(name+"("+color+"/"+year+")");
	}
	
	//power 메서드
	public void power() {		
		if(!power) {
			power = true;
			System.out.println("power : ON");
		} else {
			power = false;
			System.out.println("power : OFF");
		}
	}
	
	//speed up 
	public void speedUp() {
		if(this.power) {
			this.speed += 10;
			System.out.println("speed : "+ speed);
		} else {
			System.out.println("시동이 꺼져있습니다.");
		}
	}
		
	//speed down
	public void speedDown() {
		if(this.power) {
			this.speed -= 10;
			System.out.println("speed : " + speed);
		} else {
			System.out.println("시동이 꺼져있습니다.");
		}
	}
	

	
}
