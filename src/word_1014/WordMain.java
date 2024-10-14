package word_1014;

import java.io.IOException;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/* 단어장 프로그램
		 * 1.단어등록|2.단어검색|3.단어수정|4.단어출력|5.단어삭제|6.단어파일로 출력|7.종료
		 * Word class 생성
		 * - 단어, 뜻 ( List<String> )
		 * 
		 * Word (equals 사용) : 단어가 같으면 같은 객체 -> 삭제, 수정, 출력
		 * */
		
		WordController wc = new WordController();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		wc.addWord();
		
		do {
			System.out.println("1.단어등록|2.단어검색|3.단어수정|4.단어출력|"
					+ "5.단어삭제|6.단어파일로 출력|7.종료");
			System.out.println("메뉴를 선택하시오 >");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: wc.insertWord(scan);
				break;
			case 2: wc.searchWord(scan);
				break;
			case 3: wc.modifyWord(scan);
				break;
			case 4: wc.printWord();
				break;
			case 5: wc.deleteWord(scan);
				break;
			case 6: try {
					wc.wordTextFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7: System.out.println("종료!"); 
			break;
			default: System.out.println("잘못 선택한 메뉴입니다.");
			}
			
		} while(menu != 7);
		
		
		scan.close();
	}

}
