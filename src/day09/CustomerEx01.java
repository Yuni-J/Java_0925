package day09;

public class CustomerEx01 implements Comparable<CustomerEx01> {

	private String name;
	private int age;
	private int cost;
	
	public CustomerEx01() {}
	public CustomerEx01(String name, int age) {
		this.name = name;
		this.age = age;
		this.cost = age >=15 ? 100 : 50;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ") 비용:"+cost+"만원";
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
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public int compareTo(CustomerEx01 o) {
		// this 와 o 객체를 정렬
		return this.name.compareTo(o.name);
	}
}
