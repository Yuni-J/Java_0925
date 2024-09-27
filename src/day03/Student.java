package day03;

public class Student {

/* 학생 클래스 생성
 * 맴버변수 : 지점, 이름, 과정, 전화번호
 * 생성자
 * - 지점과 이름만 받는 생성자
 * - 지점, 이름, 과정, 전화번호를 받는 생성자 (생성자 호출로 호출)
 * 메서드 : 해당 내용을 출력하는 메서드 print()
 * - getter / setter
 *  
 * */
	public static void main(String[] args) {
		Student s = new Student("인천","홍길동");
		s.print();
		System.out.println();
		
		s.setCourse("풀스택");
		s.setPhone("010-1234-5678");
		s.print();
		
	}

	private String addr;
	private String name;
	private String course;
	private String phone;
	
	//생성자 호출
	public Student() {}
	public Student(String addr, String name) {
		this.addr = addr;
		this.name = name;
	}

	public Student(String addr, String name, String course, String phone) {
		this(addr,name);
		this.course = course;
		this.phone = phone;
	}
	public void print() {
		System.out.println("지점:"+addr+" / 이름:"+name+" / 과정:"+course+" / 전화번호:"+phone);
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
