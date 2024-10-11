package sale_1010;
/* Order Class 생성(Menu 상속)
 * : 주문번호/(제품ID/제품명/가격)/수량/결제금액
 * */
public class Order extends Menu {
	
	private int orderNum;
	private int amount;
	private int payment;
	
	public Order() {}
	public Order(int orderNum, String id, String name, int price, int amount, int payment) {
		super(id, name, price);
		this.orderNum = orderNum;
		this.amount = amount;
		this.payment = price * amount;
	}
	public Order(int orderNum, String name, int amount) {
		super.setproductName(name);
		this.orderNum = orderNum;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return 
		 "주문번호:" + orderNum +", "+super.toString()+", 수량:" + amount + ", 금액:" + payment;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
}
