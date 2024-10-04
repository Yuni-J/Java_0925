package lotto;

public class LottoExtend extends Lotto {

	private int bonusNum;
	
	public LottoExtend() {}
	public LottoExtend(int bonusNum) {
		this.bonusNum = bonusNum;
	}

	@Override
	public String toString() {
		return "[" + bonusNum + "]";
	}
	
	
	public int getBonusNum() {
		return bonusNum;
	}
	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	} 
	




}
