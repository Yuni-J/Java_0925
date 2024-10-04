package Student_1002;

public class Subject {
	// 수강정보
	// 과목코드,과목명,학점,시수,교수명,시간표,강의장
	/* 맴버변수 / 생성자 / getter/setter / toString(수강정보 출력)
	 * */
	
	private String code;  //과목코드
	private String subjectName;  //과목명
	private String point;  //학점
	private String time; //시수
	private String professor;//교수명
	private String timetable;  //시간표
	private String room;//강의장
	
	// 생성자
	public Subject() {}
	
	// 과목코드 / 과목명만 받는 생성자
	public Subject(String code, String subjectName) {
		this.code = code;
		this.subjectName = subjectName;
	}
	
	public Subject(String code, String subjectName, String point, String time, String professor, String timetable,
			String room) {
		this(code, subjectName);
		this.point = point;
		this.time = time;
		this.professor = professor;
		this.timetable = timetable;
		this.room = room;
	}
	

	@Override
	public String toString() {
		return "Subject [code=" + code + ", subjectName=" + subjectName + "]";
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

