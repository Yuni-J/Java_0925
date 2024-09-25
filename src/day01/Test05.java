package day01;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		// ex) 검색어를 입력받아 fileName 배열에 검색어가 존재하면 해당 파일 이름을 출력
		/* 검색어 : java
		 * spring.java
		 * String.java
		 * 
		 * 검색어 : s
		 * spring.java
		 * react.jsx
		 * css.css
		 * String.java
		 * component.jsx
		 * 
		 * 검색어 : 가나다
		 * 검색결과가 없습니다.
		 * */
		Scanner scan = new Scanner(System.in);
		
		String[] fileName = {"spring.java", "python.py", "react.jsx", "css.css", "String.java",
				"component.jsx", "text.txt"};
		
		System.out.println("검색어를 입력해주세요."
				+ "");
		String input = scan.next();
		System.out.println("[검색어 : " + input + "]");
		
		int count = 0;
		
		for(String file : fileName) {
//			System.out.println(file.contains(input));
			if(file.contains(input) == true) {
				System.out.println(file);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("검색결과가 없습니다.");
		}
		scan.close();
	}

}
