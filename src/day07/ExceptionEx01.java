package day07;


public class ExceptionEx01 {

	public static void main(String[] args) {
		// 리턴 받을 배열 출력
		
//		int[] arr = null;
		
		ExceptionEx01 e01 = new ExceptionEx01();
		
		
		try {
			int[] arr = e01.exception01(5, 1, 5);
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println();
		try {
//			int[] arr2 = new int[5];
			int[] arr2 = null;
			e01.exception02(arr2, 1, 5);
			for(int i=0; i<arr2.length; i++) {
				System.out.println(arr2[i]);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}
	/* 메서드 생성
	 * 기능 : size를 입력받아(매개변수) size만큼의 길이를 가지는 배열을 생성하여
	 * 랜덤값을 채워 배열을 리턴
	 * 랜덤값은 범위를 매개변수를 받아 start(시작값), count(개수)
	 * - size가 0보다 작으면 예외발생
	 * - 랜덤값의 개수가 0이면 예외발생
	 * */
	public int[] exception01(int size, int start, int count) throws Exception {
		if(size <= 0) {
			throw new Exception("size가 0보다 작습니다.");
		} else if(count <= 0){
			throw new Exception("count개수가 0개 입니다.");
		}
		
		int[] array = new int[size];
		
		for(int i=0; i<size; i++) {
			array[i] = (int)(Math.random()*count)+start;
		}
		return array;	
	}
	
	/* 메서드
	 * 기능 : 매개변수로 배열을 받아 랜덤값을 채우는 메서드
	 * 랜덤값은 범위를 매개변수를 받아 start(시작값), count(개수)
	 * - 랜덤값의 개수가 0이면 예외발생
	 * - 배열이 null이면 예외발생
	 * - 배열의 길이가 0보다 작으면 예외발생
	 * */
	public void exception02(int[] array2, int start, int count) throws Exception {
		
		if(array2 == null) {
			throw new Exception("배열이 null입니다.");
		} else if(array2.length <= 0) {
			throw new Exception("배열의 길이가 0보다 작습니다.");
		} else if(count <= 0){
			throw new Exception("count개수가 0개 입니다.");
		}
		
		for(int i=0; i<array2.length; i++) {
			array2[i] = (int)(Math.random()*count)+start;
		}
		
	}

}
