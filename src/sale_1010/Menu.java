package sale_1010;
/* Menu Class 생성
 * : 제품ID/제품명/가격/
 * */
public class Menu {
	
	private String productID;
	private String prodectName;
	private int price;
	
	public Menu() {}
	public Menu(String productID, String prodectName, int price) {
		this.productID = productID;
		this.prodectName = prodectName;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "상품번호="+productID+", 상품명="+prodectName+", 가격="+price;
	}
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProdectName() {
		return prodectName;
	}
	public void setProdectName(String prodectName) {
		this.prodectName = prodectName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
