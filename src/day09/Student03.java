package day09;

public class Student03 {
	
	private String name;
	private int score;
	
	public Student03() {}
	public Student03(String name, int score) {
		this.name = name;
		this.score = score;
	}


	@Override
	public String toString() {
		return name + " : " + score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
