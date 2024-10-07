package day06;

public class VIPCustomer extends Customer {
	private double saleRatio;  //할인율 Gold / VIP만 존재
	private int agentID; //VIP만 존재
	
	public VIPCustomer() {}
	public VIPCustomer(int id, String name, int agentid) {
		super(id, name);
		customerGrade = "Gold";
		bonusRatio = 0.02;
		saleRatio = 0.1;
		agentID = agentid;
	}
	@Override
	public int bonusCalc(int price) {
		bonusPoint = bonusPoint + (int)(price * bonusRatio);
		price = price - (int)(price*saleRatio);
		return price;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("담당 상담원 번호는 "+agentID);
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	
	
	
}
