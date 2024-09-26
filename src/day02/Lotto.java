package day02;

public class Lotto {

	public static void main(String[] args) {
		/* 로또 번호 생성
		 * 
		 * */
		
		int[] lotto = new int[7];  //당첨 번호
		int[] user = new int[6];  //사용자 로또 번호
		

		
		Lotto l = new Lotto();
		l.randomArr(lotto);
		l.randomArr(user);
		System.out.println("---로또 번호---");
		l.printArr(lotto);
		System.out.println();
		System.out.println("---유저 번호---");
		l.printArr(user);
		System.out.println();
		System.out.println("--당첨 결과--");
		l.rank(lotto,user);
		
		
		

	}
	/* 배열을 매개변수로 받아 1~45까지의 랜덤수를 채워서 생성 (중복불가능 - 메서드 호출로 구현)
	 * 리턴할 필요가 없음. mian에 있는 배열을 채우기.
	 * */
	public void randomArr(int[] arr) {
		int count = 0;
		
		while(count<arr.length) {
			int random = (int)(Math.random()*10)+1;
			if(!isContain(arr, random)) {
				arr[count] = random;
				count++;
			}	
		}
	}

	/* 배열과 값을 주고 같은지 아닌지 확인하는 메서드
	 * 배열에 값이 있으면 true / 없으면 false
	 * */
	public boolean isContain(int[] arr, int random) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == random) {
				return true;
			}
		}
		return false;
	}
	
	
	/* 배열(매개변수)의 값을 출력하는 메서드
	 * 1 2 3 4 5 6 [7] 당첨번호 출력
	 * 1 2 3 4 5 6 유저번호 출력방식
	 * */
	public void printArr(int[] arr) {
		for(int i=0; i<6; i++) {
			System.out.print(arr[i] + " ");
		}
		if(arr.length == 7) {
			int b = arr[6];
			System.out.print("["+b+"]");
		}
	}

	/* 등수확인 메서드
	 * --당첨 기준
	 * user번호 기준으로 
	 * 6개 일치 : 1등
	 * 5개 일치 + 보너스 번호 : 2등
	 * 5개 일치 : 3등
	 * 4개 일치 : 4등
	 * 3개 일치 : 5등
	 * 나머지는 꽝
	 * */
	public void rank(int[] lotto, int[] user) {
		int count = 0;
		
		for(int i=0; i<user.length; i++) {
			if(isContain(user, lotto[i])) {
				count++;
			}
		}		
		switch(count) {
		case 6: System.out.println("1등 당첨");
			break;
		case 5: 
			if(isContain(user,lotto[lotto.length-1])) {
				System.out.println("2등 당첨");
			} else {
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

	
}
