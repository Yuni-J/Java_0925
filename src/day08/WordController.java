package day08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordController {
	
	private Map<String, String> map = new HashMap<>();

	public void addWord() {
		String[] word = {"apple", "orange", "grape", "banana", "strawberry"};
		String[] mean = {"사과", "오렌지", "포도", "바나나", "딸기"};
		
		for(int i=0; i<word.length; i++) {
			map.put(word[i], mean[i]);
		}	
	}

	public void insertWord(Scanner scan) {
		System.out.println("등록할 단어를 입력하시오");
		System.out.print("단어  > ");
		String word = scan.next();
		System.out.print("의미  > ");
		String mean = scan.next();
		System.out.println();
		
		map.put(word, mean);

	}

	public void searchWord(Scanner scan) {
		System.out.println("검색할 단어를 입력하시오");
		System.out.print("단어 > ");
		String searchWord = scan.next();
		
		if(map.containsKey(searchWord)) {
			System.out.println("--검색된 단어--");
			System.out.println(searchWord+":"+map.get(searchWord));
			System.out.println("-------------");
			return;
		}
		System.out.println("단어를 찾을 수 없습니다.");
		System.out.println();
		
//		for(String key : map.keySet()) {
//			if(key.equals(searchWord)) {
//				System.out.println("찾은 단어 ["+key+" : "+map.get(key)+"]");
//				System.out.println();
//				return;
//			}
//		}
//		System.out.println("단어를 찾을 수 없습니다.");
//		System.out.println();
	}

	public void modifyWord(Scanner scan) {
		// 단어수정 : 키 중복이 안됨.  add => 덮어씀
		// 삭제 후 다시 추가
		System.out.println("수정할 단어를 입력하시오");
		System.out.print("단어  > ");
		String searchWord = scan.next();
		if(map.remove(searchWord)==null) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
		System.out.println("수정할 의미  > ");
		String mean = scan.next();
		map.put(searchWord, mean);
		System.out.println("수정완료");

//		for(String key : map.keySet()) {
//			if(key.equals(searchWord)) {
//				String modifyWord = scan.next();
//				map.put(searchWord, modifyWord);
//				System.out.println("단어가 수정되었습니다.");
//			}
//			System.out.println("단어를 찾을 수 없습니다.");
//			System.out.println();
//		}
		
	}

	public void printWord() {
		System.out.println("--단어장--(단어:의미)");
		for(String k : map.keySet()) {
			System.out.println(k+" : "+map.get(k));
		}
		System.out.println("-----------------");
		
	}

	public void deleteWord(Scanner scan) {
		System.out.println("삭제할 단어를 입력해주세요");
		System.out.print("단어  >");
		String deleteWord = scan.next();
		String mean = map.remove(deleteWord);  //삭제완료
		if(mean==null) {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		System.out.println("삭제완료");	
	}
}
