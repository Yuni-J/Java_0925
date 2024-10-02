package day05;

public class Product {
	private String name;
	private int price;
	private int num;
	private static int index;
	
	//생성자
	public Product() {}
	public Product(String name, int price) {
		this.index++;
		this.name = name;
		this.price = price;
	}
	//메서드 : 상품추가, toString
	public void insertProduct(String name, int price) {
		this.index++;
		this.num = index;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return num+". "+ name + ":" + price+"원";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
