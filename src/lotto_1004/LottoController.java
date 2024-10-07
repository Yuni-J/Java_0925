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

	public void LottoRank() {
		// 4.당첨확인
//		LottoExtend tempLotto = new LottoExtend();
//		
//		int[] lottoNumber = tempLotto.getNumbers();
//		int bonus = tempLotto.getBonus();
//				
//		// 사용자 번호와 당첨번호 비교
//		int count = 0;
//		
//		for(int userNum : user.getNumbers()) {
//			for(int lottoNum : lottoNumber) {
//				if(userNum == lottoNum) {
//					count++;
//					break;
//				}
//			}
//		}
//		//보너스 번호 확인
//		boolean bonusCheck = false;
//		for(int userNum : user.getNumbers()) {
//			if(userNum == bonus) {
//				bonusCheck = true;
//				break;
//			}
//		}
//	
//		switch(count) {
//		case 6: System.out.println("1등 당첨");
//			break;
//		case 5: 
//			if(bonusCheck) {
//				System.out.println("2등 당첨");
//			} else{
//				System.out.println("3등 당첨");
//			}
//			break;
//		case 4: System.out.println("4등 당첨");
//			break;
//		case 3: System.out.println("5등 당첨");
//			break;
//		default: System.out.println("꽝!");
//		}	
		// 당첨번호와 유저번호를 체크하여 등수를 출력
		// 사용자번호와 가장 마지막 당첨번호를 확인하여 등수를 출력
		if(user.isContain(0)) {  //모든 값이 다 채워지지 않았거나 하나도 채워지지 않을 경우
			System.out.println("체크할 번호가 없습니다.");
			return;
		}
		// 당첨번호가 없을 경우
		if(lCount == 0) {
			System.out.println("당첨번호가 없습니다.");
			return;
		}
		int count = 0;
		// 가장 마지막 당첨번호 저장
		LottoExtend temp = lotto[lCount-1];
		
		//회차 일치 여부 확인
		if(temp.getSt() != user.getSt()) {
			System.out.println("회차가 맞지 않습니다.");
			return;
		}
		
		//for문으로 일치하는 개수 확인
		for(int i=0; i<user.getNumbers().length; i++) {
			int num = temp.getNumbers()[i];
			if(user.isContain(num)) {
				count++;
			}
		}
		int rank = -1;
		switch(count) {
		case 6: rank = 1;
			break;
		case 5: 
			if(user.isContain(temp.getBonus())) {
				rank = 2;
			} else {
				rank = 3;
			}
//			rank = user.isContain(temp.getBonus()) ? 2 : 3;
			break;
		case 4: rank = 4;
			break;
		case 3: rank = 5;
			break;
		default: System.out.println("꽝!");
		}
		if(rank != -1) {
			System.out.println(rank+"등 당첨!");
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
