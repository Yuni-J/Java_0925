package day04;

class Animal{
	// 동물의 이름과 종류를 나타내는 클래스
	// 메서드 : 이름과 종유를 출력하는 메서드, 동물의 울음소리를 출력하는 메서드
	private String name;
	private String category;
	
	public Animal() {}
	public Animal(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	// 출력 메서드
	public void printInfo() {
		System.out.println("이름:"+name+" / 종류:"+category);
	}
	
	// 울음소리 출력 메서드
	public void howl() {
		System.out.println("--"+name+"의 울음소리 --");
		// 자식이 구현
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}

// Dog, Cat Animal 클래스를 상속받아 생성
// printInfo() / howl() : 오버라이딩 후 본인의 울음소리를 추가해서 출력

class Dog extends Animal{
	//생성자
	public Dog() {
		setName("멍뭉이");   // <- super.setName에서 super. 생략가능
		setCategory("개과");
	}
	
	@Override
	public void howl() {
		//부모의 howl() 메서드 값
		super.howl();
		System.out.println("mow-wow");
	}
}
class Cat extends Animal{
	public Cat(String name, String category) {
		super.setName(name);
		super.setCategory(category);
	}
	
	@Override
	public void howl() {
		super.howl();
		System.out.println("meow");	
	}
}
class Tiger extends Animal{
	public Tiger(String name, String category) {
		super(name, category);  //부모 생성자 호출
	}

	@Override
	public void howl() {
		super.howl();
		System.out.println("어흥");
	}
	
}

public class Extends02 {

	public static void main(String[] args) {
		// 오버라이딩 : 부모클래스의 메서드를 재정의하여 사용하는 
		// - 부모클래스의 메서드와 선언부가 일치해야함. { 구현만 재정의 가능 }
		// - 접근제한자는 더 넓은 범위만 가능, 축소는 안됨.
		
		Dog d = new Dog();
		d.printInfo();
		d.howl();
		
		Cat c = new Cat("냐옹이","고양이과");
		c.printInfo();
		c.howl();
		
		Tiger t = new Tiger("호범이", "고양이과");
		t.printInfo();
		t.howl();
	}

}
