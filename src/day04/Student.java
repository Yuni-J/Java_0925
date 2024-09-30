package day04;
/* - 학생 정보를 관리하기 위한 클래스
 * - 학생 기본정보 : 이름, 생년월일, 전화번호, 나이
 * - 학원 정보 : 학원명="EZEN" (final static), 지점
 * - 수강 정보 : 수강과목, 기간
 * => 여러과목을 들을 수 있음.(여러과목을 수강하기 위해서는 배열로 처리 5과목까지 가능)
 * 
 * ex) 홍길동(010101) 010-1111-1111 / 25 -> 학생정보 
 * 		EZEN(인천) -> 학원정보
 * 		자바 6개월, 파이썬 1개월, SQLD 1개월 -> 수강정보
 * 
 * 기능(메서드)
 * - 학생의 기본정보를 출력하는 기능
 * - 학원 정보를 출력하는 기능
 * - 수강정보를 출력하는 기능
 * - 학생이 수강정보를 추가하는 기능
 * */
public class Student {
	private String name;
	private String birth;
	private String phone;
	private String age;
	private static final String ACADEMY = "EZEN";
	private String addr;
    private Course[] courses = new Course[5];
//	private String[] courses = new String[5];
    private int courseCount = 0; // 현재 수강 과목 수

    // 생성자
	public Student() {}
	public Student(String name, String birth, String phone, String age, String addr) {
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.age = age;
		this.addr = addr;
	}
	
	// Course 클래스
	public class Course{
        String subject;
        String duration;

        Course(String subject, String duration) {
            this.subject = subject;
            this.duration = duration;
        }
        public String getSubject() {
        	return subject;
        }
        public void setSubject(String subject) {
        	this.subject = subject;
        }
        public String getTerm() {
        	return duration;
        }
        public void setTerm(String duration) {
        	this.duration = duration;
        }   
	}
	
	//학생정보 출력
	public void studentPrint() {
		System.out.println("학생정보 : "+name+"("+age+") : "+birth+" | "+phone);
	}
	
	//학원정보 출력
	public void academyPrint() {
		System.out.println("학원정보 : "+ACADEMY+"("+addr+")");
	}
	
	//수강정보 출력
	public void coursePrint() {
		System.out.print("수강정보 : ");
		for(int i=0; i<courseCount; i++) {
			Course c = courses[i];
			System.out.print(c.subject+"("+c.duration+")  ");
		}
		System.out.println();
		if(courseCount == 0) {
			System.out.println("수강과목이 없습니다.");
		}
	}
	
	//수강정보 추가 
	public void addCourse(String subject, String duration) {
		if(courseCount < 5) {
			courses[courseCount] = new Course(subject, duration);
			courseCount++;
//			System.out.println("수강정보 추가 : "+subject+"("+duration+")");
		} else {
			System.out.println("더 이상 추가를 할 수 없습니다.");
		}
	}	
	
	// 특정 과목을 수강하는지 확인하는 메서드
	public boolean subjectCheck(String subject) {
	    for (Course c : courses) {
	        if (c != null && c.getSubject().equals(subject)) {
	            return true;
	        }
	    }
	    return false;
	}
	

	// getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAcademy() {
		return ACADEMY;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}	
	public int getCourseCount() {
		return courseCount;
	}
	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
}
