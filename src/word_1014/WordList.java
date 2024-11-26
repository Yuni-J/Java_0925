package word_1014;

import java.util.ArrayList;
import java.util.List;

public class WordList {
	private int meanNum;
//	private List<Word> word = new ArrayList<>();
    private List<String> meanings = new ArrayList<>(); // 의미들을 저장할 리스트

    public WordList() {}
    public WordList(int meanNum) {
    	this.meanNum = 1;
    }
    
    public void add(String meaning) {
        this.meanings.add(meaning); // 의미 추가
    }
	
	
	@Override
	public String toString() {
//		return meanNum+")"+meanings;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < meanings.size(); i++) {
            sb.append(i+1).append(") ").append(meanings.get(i)).append("\n"); // 각 의미를 개별적으로 출력
        }
        return sb.toString(); // 최종 문자열 반환
	}

	public int getMeanNum() {
		return meanNum;
	}

	public void setMeanNum(int meanNum) {
		this.meanNum = meanNum;
	}

	public List<String> getMeanings() {
		return meanings;
	}

	public void setMeanings(List<String> meanings) {
		this.meanings = meanings;
	}

}
