package Student_1002;

public class Student {
	/* Studnet : 학생정보
	 * - 학번,이름,나이,전화번호,주소,수강과목s(Subject clss를 배열로 처리)
	 * Subject : 과목정보 
	 * - 과목코드,과목명,학점,시수,교수명,시간표,강의장
	 * */
	
	private String num;  //학번
	private String name;  //이름
	private String age;  //나이
	private String phone;  //전화번호
	private String addr;  //주소
	private Subject[] subjects;  //수강과목s
	
	// 생성자
	public Student() {}
	public Student(String name, String num, String addr, String age, String phone) {
		this.name = name;
		this.num = num;
		this.addr = addr;
		this.age = age;
		this.phone = phone;
	}

	// Subject 클래스
	public class Subject{
		private String code;  //과목코드
		private String subjectName;  //과목명
		private String point;  //학점
		private String time; //시수
		private String professor;//교수명
		private String timetable;  //시간표
		private String room;//강의장
		
		// 생성자
		public Subject() {}
		public Subject(String code, String subjectName, String point, String time, String professor, String timetable,
				String room) {
			this.code = code;
			this.subjectName = subjectName;
			this.point = point;
			this.time = time;
			this.professor = professor;
			this.timetable = timetable;
			this.room = room;
		}

		// getter/setter
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getSubjectName() {
			return subjectName;
		}
		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}
		public String getPotin() {
			return point;
		}
		public void setPoint(String point) {
			this.point = point;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getProfessor() {
			return professor;
		}
		public void setProfessor(String professor) {
			this.professor = professor;
		}
		public String getTimetable() {
			return timetable;
		}
		public void setTimetable(String timetable) {
			this.timetable = timetable;
		}
		public String getRoom() {
			return room;
		}
		public void setRoom(String room) {
			this.room = room;
		}
	}
	//학생정보
	@Override
	public String toString() {
		return name+"("+num+") : "+addr+"("+age+") "+phone;
	}
	
	
	// getter/setter
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Subject[] getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}
}
