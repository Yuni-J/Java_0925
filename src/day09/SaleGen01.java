package day09;

//Generics => <K, V> 대문자로 사용
public class SaleGen01<K,V> {
	// 제너릭의 타입 값은 대문자로...
	// 멤버변수 id, menum price
	private K id;
	private V menu;
	private int price;
	public SaleGen01() {}
	public SaleGen01(K id, V menu, int price) {
		this.id = id;
		this.menu = menu;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Sale [" + id + " . " + menu + " : " + price + "]";
	}
	
	public K getId() {
		return id;
	}
	public void setId(K id) {
		this.id = id;
	}
	public V getMenu() {
		return menu;
	}
	public void setMenu(V menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
