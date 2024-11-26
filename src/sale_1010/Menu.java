package sale_1010;
/* Menu Class 생성
 * : 제품ID/제품명/가격/
 * */
public class Menu {
	
	private String productID;
	private String productName;
	private int price;
	
	public Menu() {}
	public Menu(String productID, String productName, int price) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "상품번호:"+productID+", 상품명:"+productName+", 가격:"+price;
	}
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
