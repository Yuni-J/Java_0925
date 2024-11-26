package word_1014;

import java.util.Objects;

public class Word {
	private int wordId;
	private String name;
//	private String mean;
	private WordList  meanings;
	
	public Word() {}
	public Word(int id, String name, WordList meanings) {
		this.wordId = id;
		this.name = name;
		this.meanings = meanings;
	}

	@Override
	public String toString() {
		return wordId+". "+name+"\r\n"+meanings ;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WordList getMeanings() {
		return meanings;
	}
	public void setMeanings(WordList meanings) {
		this.meanings = meanings;
	}

	@Override
	public int hashCode() {
		return Objects.hash(meanings, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(meanings, other.meanings) && Objects.equals(name, other.name);
	}
}
