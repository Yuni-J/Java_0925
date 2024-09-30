package day03;
/* 학생 클래스 생성
 * 맴버변수 : 지점, 이름, 과정, 전화번호
 * 생성자
 * - 지점과 이름만 받는 생성자
 * - 지점, 이름, 과정, 전화번호를 받는 생성자 (생성자 호출로 호출)
 * 메서드 : 해당 내용을 출력하는 메서드 print()
 * - getter / setter
 * */

/* 객체를 생성시 값을 초기화 하는 방법
 * - 기본값, 명시적 초기값,
 * 1. 기본값 : 기존벅으로 지정되는 값 int = 0 / String = null
 * 2. 명시적 초기값 : 사용자가 맴버변수를 선언함과 동시에 값을 지정
 * 3. 초기화 블럭 : { } 맴버변수들의 초기화 
 * 4. 생성자 : 객체 생성시 초기화를 해서 생성
 * 
 * 초기값의 우선순위 (순위가 높은 값으로 덮어쓰여짐)
 * 기본값 -> 명시적 초기값 -> 초기화블럭 -> 생성자(가장 우선 순의가 높음)
 * */

public class Student {

	private String addr = "incheon";  //2. 명시적 초기값
	private String name;  //1. 기본값 기본적으로 주는 null / 0의 값
	private String course;
	private String phone;
	{  
		//3. 초기화 블럭 영역
		name = "student";
		course = "JAVA";
	}  
	
	//생성자 호출
	public Student() {}  //4. 기본 생성자
	public Student(String addr, String name) {
		this.addr = addr;
		this.name = name;
	}

	public Student(String addr, String name, String course, String phone) {
		this(addr,name);
		this.course = course;
		this.phone = phone;
	}
	// 객체의 내용을 출력하는 메서드(toString)
	public void print() {
		System.out.println("지점:"+addr+" | 이름:"+name+" | 과정:"+course+" | 전화번호:"+phone);
	}
	
	// @Override : 어노테이션(애너테이션) => 작은 기능이 있는 정의어
	// override(오버라이드) : 부모의 메서드를 자식이 가져와서 재정의 하는 기능
	// 생성자, getter/setter, toString => 자동생성해줌.
	@Override
	public String toString() {
		return "Student [addr=" + addr + ", name=" + name + ", course=" + course + ", phone=" + phone + "]";
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
