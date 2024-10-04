package lotto;

import java.util.Arrays;

public class Lotto {
	
	private int[] lottoNum = new int[6];
	private int count = 0;
	
	public Lotto() {}
	public Lotto(int[] lottoNum) {
		this.lottoNum = lottoNum;
	}
	
	//로또번호 출력
	@Override
	public String toString() {
		return Arrays.toString(lottoNum);
	}
	
	//수동로또번호 생성 메서드
	public void manualLotto(int[] arr) {
		if(arr.length != 6) {
			System.out.println("수동 로또 번호는 6개여야 합니다.");
			return;
		}
//		while(count<arr.length) {
//			int a = 0;
//			if(!isContain(arr, a)) {
//				arr[count] = a;
//				count++;
//			}
//		}
		System.arraycopy(arr, 0, lottoNum, 0, arr.length);
	}
	
	
	//자동로또번호 생성 메서드
	public void autoLotto(int[] arr) {
		while(count<arr.length) {
			int random = (int)(Math.random()*10)+1;
			if(!isContain(arr,random)) {
				arr[count] = random;
				count++;
			}
		}
		
	}

	//배열과 값을 주고 같은지 아닌지 확인하는 메서드
	public boolean isContain(int[] arr, int random) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == random) {
				return true;  //중복 있은 경우
			}
		}
		return false;  //중복 없는 경우
	}
	
	public int[] getLottoNum() {
		return lottoNum;
	}
	public void setLottoNum(int[] lottoNum) {
		this.lottoNum = lottoNum;
	}
}
