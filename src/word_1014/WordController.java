package word_1014;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordController {
	List<Word> word = new ArrayList<>();
	List<WordList> wordList = new ArrayList<>();
	
	private int wordId;
	private int meanNum;
	
	public void addWord() {
		//기존 단어 추가
		word.add(new Word(++wordId, "오늘", new WordList()));
		word.get(word.size()-1).getMeanings().add("지금 지나가고 있는 이날.");
		word.get(word.size()-1).getMeanings().add("지금의 시대.");
		word.get(word.size()-1).getMeanings().add("지금 지나가고 있는 이날에.");
		word.add(new Word(++wordId, "내일", new WordList()));
		word.get(word.size()-1).getMeanings().add("오늘의 바로 다음 날.");
		word.get(word.size()-1).getMeanings().add("다가올 앞날.");
		word.get(word.size()-1).getMeanings().add("오늘의 바로 다음 날에.");
		word.add(new Word(++wordId, "어제", new WordList()));
		word.get(word.size()-1).getMeanings().add("오늘의 바로 하루 전날.");
		word.get(word.size()-1).getMeanings().add("지나간 때.");
		word.get(word.size()-1).getMeanings().add("오늘의 바로 하루 전에.");

	}

	public void insertWord(Scanner scan) {
		// 1.단어등록
		System.out.println("등록할 단어를 입력하시오");
		System.out.println("단어 > ");
		String name = scan.next();
		scan.nextLine();
		
		WordList meanList = new WordList();
		
		while(true) {
			System.out.println("의미 ('끝'을 입력하면 등록종료!)> ");
			String mean = scan.nextLine();
			if(mean.equals("끝")) {
				break;
			}
			meanNum++;
			meanList.add(mean);
		}
		wordId++;
		word.add(new Word(wordId, name, meanList));
		
		System.out.println("단어가 등록되었습니다.");
		System.out.println();
	}


	public void searchWord(Scanner scan) {
		// 2.단어검색
		System.out.println("검색할 단어를 입력하시오");
		System.out.println("단어 > ");
		String name = scan.next();
		
		for(Word w : word) {
			if(w.getName().equals(name)) {
				System.out.println("--"+name+"--");
				System.out.println(w.getMeanings());
				System.out.println("------------");
				return;
			} 
		} 
		System.out.println("검색 결과가 없습니다.");
		System.out.println();
	}

	public void modifyWord(Scanner scan) {
		// 3.단어수정
		System.out.println("수정할 단어를 입력하시오");
		System.out.println("단어 > ");
		String name = scan.next();
		
		for(Word w : word) {
			if(w.getName().equals(name)) {
				System.out.print("수정할 번호를 입력하시오 > ");
				meanNum = scan.nextInt();
				scan.nextLine(); // 개행 문자 소비
	            // 의미 번호가 범위 내인지 확인
	            if (meanNum >= 0 && meanNum < w.getMeanings().getMeanings().size()) {
	                System.out.println("수정할 내용을 작성하시오");
	                String modifyMean = scan.nextLine();
	                
	                // 해당 의미 수정
	                w.getMeanings().getMeanings().set(meanNum, modifyMean);
	                System.out.println("단어가 수정되었습니다.");
	                System.out.println();
	            } else {
	                System.out.println("유효하지 않은 의미 번호입니다.");
	                System.out.println();
	            }
	            return; // 수정 후 메서드 종료
			}
		}
	}

	public void printWord() {
		// 4.단어출력
		System.out.println("--Word--");
		for(Word w : word) {
			System.out.println(w);
		}
		System.out.println("--------");
		System.out.println();	
	}

	public void deleteWord(Scanner scan) {
		// 5.단어삭제
		System.out.println("삭제할 단어를 입력하시오");
		System.out.println("단어 > ");
		String name = scan.next();
		
		for(Word w : word) {
			if(w.getName().equals(name)) {
				word.remove(w);
				System.out.println("삭제가 되었습니다.");
				System.out.println();
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
		System.out.println();		
	}

	public void wordTextFile() throws IOException {
		// 6.단어파일로 출력
//		File f = new File("D:\\yuni_240725\\java_workspace\\java_project\\vocabulary.txt");
		FileWriter fw = new FileWriter("wordBook.txt", true);
		for(Word w : word) {
			fw.write(w.toString());
			fw.append("\r\n");
		}

		System.out.println("단어가 파일로 출력합니다.");
		System.out.println();	
		fw.close();
		
		//파일로 출력
		//StringBuffer 객체 사용
		// .append : 기존 String 객체에 데이터 추가
		FileWriter fs = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fs);
		
		StringBuffer sb = new StringBuffer();
		String data = null;
		sb.append("--단어장--\r\n");
		
		for(Word w : word) {
			sb.append(w);
			sb.append("\r\n"); //줄바꿈
		}
		data = sb.toString();
		System.out.println(data);
		bw.write(data);
		
		bw.close();
		fs.close();
	}

}
