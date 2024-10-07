package day06;

public class GoldCustomer extends Customer {
	private double saleRatio;  //할인율 Gold / VIP만 존재
	
	public GoldCustomer() {}
	public GoldCustomer(int id, String name) {
		super(id, name);
		customerGrade = "Gold";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	@Override
	public int bonusCalc(int price) {
		bonusPoint = bonusPoint + (int)(price * bonusRatio);
		price = price - (int)(price*saleRatio);
		return price;
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

}



	


