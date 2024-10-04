package lotto_1004;

import java.util.Scanner;

public class LottoController {
	// 당첨번호는 여러개 배열로 저장
	private LottoExtend lotto[] = new LottoExtend[5];
	private int lCount = 0;
	
	// 사용자 번호는 1개
	private Lotto user = new Lotto();
	
	private int st = 0;  //회차 값
	
	public void UserLottoNumber(Scanner scan) {
		// 1.수동 로또번호 입력
		System.out.println("로또번호입력(중복X, 1~45, 숫자 6개) >");
		int temp[] = new int[6];
		for(int i=0; i<temp.length; i++) {
			temp[i] = scan.nextInt();		
		}
		if(isDuplicated(temp)) {
			System.out.println("오류발생 다시 입력하세요!!");
		} else {
			user.insertNumbers(temp);
			user.st = this.st+1;
			System.out.println(user);
		}
		
	}
	
	//수동으로 입력되는 로또번호의 중복체크, 범위체크
	public boolean isDuplicated(int[] arr) {  //매개변수 사용 -> 들어갈 배열이 두개이기 때문
		//중복확인
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		
		//범위확인
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<0 || arr[i]>45) {
				return true;
			}
		}
		
		return false;
	}

	public void AutoLottoNumber() {
		// 2.자동 로또번호 입력
		user.randomLotto();
		user.st = this.st+1;
		System.out.println(user);		
	}

	public void LottoWinningNumber(Scanner scan) {
		// 3.당첨번호(수동)
		System.out.println("당첨번호입력(중복X, 1~45, 숫자 7개) >");
		int temp[] = new int[6];
		for(int i=0; i<temp.length; i++) {
			temp[i] = scan.nextInt();		
		}
		int  bonus = scan.nextInt();
		
		if(isDuplicated(temp)) {
			System.out.println("오류발생 다시 입력하세요!!");
		} else {
			LottoExtend tempLotto = new LottoExtend();
			tempLotto.insertNumbers(temp, bonus);
			this.st++;
			tempLotto.st = st;
			lotto[lCount] = tempLotto;
			lCount++;
			System.out.println(tempLotto);
		}
	}
	//당첨 숫자 비교하기
	public void numComparison(int st) {
		LottoExtend tempLotto = lotto[st];
		
		int[] lottoNumber = tempLotto.getNumbers();
		int bonus = tempLotto.getBonus();
		
		//사용자 번호와 당첨 번호 비교
		int count = 0;
		
		for(int userNum : user.getNumbers()) {
			for(int lottoNum : lottoNumber) {
				if(userNum == lottoNum) {
					count++;
					break;
				}
			}
		}
		//보너스 번호 확인
		boolean bonusCheck = false;
		for(int userNum : user.getNumbers()) {
			if(userNum == bonus) {
				bonusCheck = true;
				break;
			}
		}	
	}

	public void LottoRank() {
		// 4.당첨확인
		int count = 0;
		
		


		switch(count) {
		case 6: System.out.println("1등 당첨");
			break;
		case 5: 
			if(bonusCheck) {
				System.out.println("2등 당첨");
			} else{
				System.out.println("3등 당첨");
			}
			break;
		case 4: System.out.println("4등 당첨");
			break;
		case 3: System.out.println("5등 당첨");
			break;
		default: System.out.println("꽝!");
		
		}		
	}

	public void LottoRound() {
		// 5.로또회차
		System.out.println("--당첨회차 리스트--");
		for(int i=0; i<lCount; i++) {
			System.out.println(lotto[i]);
		}
		
	}



}
