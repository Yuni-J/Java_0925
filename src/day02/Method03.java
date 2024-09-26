package day02;

public class Method03 {

	public static void main(String[] args) {
		// 정수 하나를 주면 
		// 해당 정수의 구구단 출력하는 메서드 (리턴 없음.)
		Method03 m3 = new Method03();
		for(int i=2; i<=9; i++) {
			m3.gugu(i);
		}
	}
	
	public void gugu(int dan) {
		System.out.println("----"+dan+"단----");
		for(int i=1; i<10; i++) {
			int result =  dan * i;
			System.out.print(dan+" × "+i+" = "+result+"  ");			
		}
		System.out.println();
	}

}
