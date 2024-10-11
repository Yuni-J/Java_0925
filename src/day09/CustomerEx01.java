package day09;

public class CustomerEx01 {

	private String name;
	private int age;
	private int cost;
	
	public CustomerEx01() {}
	public CustomerEx01(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "이름:" + name + " 나이:" + age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCost() {
		if(age >=15) {
			return 100;
		} else {
			return 50;
		}
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
