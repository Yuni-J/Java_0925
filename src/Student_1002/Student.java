package Student_1002;

public class Student {
	// 학생정보
	// 학번,이름,나이,전화번호,주소,수강과목s(Subject clss를 배열로 처리)
	/* 맴버변수 / 생성자 / getter/setter / toString(학생정보 출력)
	 * 수강신청 / 수강철회 / 수강과목 출력
	 * */
	
	private String num;  //학번
	private String name;  //이름
	private String age;  //나이
	private String phone;  //전화번호
	private String addr;  //주소
	private Subject[] subjects = new Subject[5];  //수강과목s
	private int cnt; //배열의 index 역할
	
	// 생성자
	public Student() {}
	
	public Student(String name, String num, String phone) {
		this.name = name;
		this.num = num;
		this.phone = phone;
	}
	
	public Student(String name, String num, String addr, String age, String phone) {
		this(name, num, phone);
		this.addr = addr;
		this.age = age;
	}

	//학생정보
	@Override
	public String toString() {
		return "Student ["+ name+"("+num+") : " + phone + "]";
	}
	
	// method
	// 학생정보 출력 메서드 (toString 이용가능)
	public void stdPrint() {
		System.out.println("학생명 : "+name+"("+num+") / " + phone);
	}
	// 수강과목을 출력 메서드
	public void subPrint() {
		if(cnt==0) {
			System.out.println("수강과목이 없습니다.");
			return;
		}
		for(int i=0; i<cnt; i++) {
			System.out.println(subjects[i]); //toString 호출
		}
	}
	
	// 수강신청 메서드 : subjects subject객체를 생성하여 추가
	// 수강과목 객체를 매개변수로 받아서 추가
	public void insertSubject(Subject sub) {
		//배열이 다 찼다면... 배열 늘려주기
		if(cnt==subjects.length) {
			Subject[] temp = new Subject[subjects.length+5];
			//배열복사
			System.arraycopy(subjects, 0, temp, 0, cnt);
			//기존 배열 변경
			subjects = temp;
		}
		subjects[cnt] = sub;
		cnt++;
	}
	
	// 수강삭제 메서드
	// 수강코드 값을 매개변수로 받아서 삭제
	public void removeSubject(String code) {
		//삭제할 코드의 위치값을 지정하는 함수
		if(code == null) {
			return;
		}
		int index = -1;
		//삭제할 코드의 위치 값 찾기
		for(int i=0; i<cnt; i++) {
			if(subjects[i].getCode().equals(code)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("찾는 과목이 없습니다.");
			return;
		}
		//삭제 : 찾은 위치부터 뒷번지를 앞번지로 옮기는 작업
//		int copyCnt = subjects.length - index - 1 ;
//		System.arraycopy(subjects, index+1, subjects, index, copyCnt);
		for(int i=0; i<cnt-1; i++) {
			subjects[i] = subjects[i+1];
		}
		//끝번지는 null처리
		subjects[cnt-1] = null;
		cnt--;		
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
