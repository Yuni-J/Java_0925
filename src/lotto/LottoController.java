package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class LottoController {
	
	private Lotto lottoList = new Lotto();
	private int count;

	public void UserLottoNumber(Scanner scan) {
		// 수동로또당첨
		int[] manualArr = new int[6];  //수동 로또번호
		System.out.println("로또 번호를 입력하시오(1~45)");	
		Lotto manualNum = new Lotto(manualArr);
		for(int i=0; i<lottoList.length; i++) {
			System.out.print("번호"+(i+1)+":");
			manualArr[i] = scan.nextInt();
		
			
			//유효성 검사
			if(manualNum.isContain(manualArr, i)) {
				System.out.println("중복된 번호입니다 : " + i);
				i--;
				continue;
			}
//			manualArr[i] = i;
//			manualNum.manualLotto(manualArr);
			lottoList[count] = manualNum;
			count++;

		}
		System.out.println("수동 : "+lottoList[5]);
	}

	public void AutoLottoNumber() {
		// 자동로또당첨
		int[] autoArr = new int[6];    //자동 로또번호

		lottoList.autoLotto(autoArr);
		
		System.out.println("자동 : "+  Arrays.toString(autoArr));	

		System.out.println("로또 번호가 자동으로 생성되었습니다.");
		System.out.println();
	}

	public void LottoWinningNumber(Scanner scan) {
		// 로또당첨번호
		int[] lottoNumber = new int[7];
		
		Lotto lottoWin = new Lotto(lottoNumber);
		lottoWin.manualLotto(lottoNumber);
		System.out.println(lottoList[0]);
		
		
	}

	public void LottoRank() {
		// 등수확인
		
	}

	public void LottoRound() {
		// 로또 회차
		
	}
	
	

}
