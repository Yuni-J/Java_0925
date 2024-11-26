package Student_1002;

import java.util.Scanner;

public class StudentController implements Program {
	// StudnetController 가 구현
	// - Student class 배열처리
	
	//맴버변수 추가
	private Student[] students = new Student[5];
	private int cnt; 
	

	@Override
	public void insertStudent(Scanner scan) {
		// 학생등록
		System.out.println("학생을 등록하시오(이름/학번/전화번호)");
		System.out.print("학생 이름 : ");
		String name = scan.next();
		System.out.print("학번 : ");
		String num = scan.next();
//		System.out.print("주소 : ");
//		String addr = scan.next();
//		System.out.print("나이 : ");
//		String age = scan.next();
		System.out.print("전화번호 : ");
		String phone = scan.next();	
		System.out.println();
		
		Student studentInfo = new Student(name,num,phone);
		//배열 늘려주기
		if(cnt == students.length) {
			Student[] temp = new Student[students.length+5];
			//배열복사
			System.arraycopy(students, 0, temp, 0, cnt);
			students = temp;
		}
		students[cnt] = studentInfo;
		cnt++;
		System.out.println();
	}

	@Override
	public void printStudent() {
		// 학생정보 출력
		System.out.println("--학생 리스트 출력--");
		for(int i=0; i<cnt; i++) {
//			System.out.println(students[i]); //toStirng 
			students[i].stdPrint(); //메서드 호출
		}
		if(cnt == 0) {
			System.out.println("등록된 학생이 없습니다.");
		}
		System.out.println();
	}

	@Override
	//해당 학번의 index 리턴
	public int searchStudent(Scanner scan) {
		// 학생검색(학생정보, 수강정보) : 학번기준
		// 학번을 입력받아 배열에서 탐색 후 학생정보 + 수강정보 출력
		// 없으면 없다고 출력
		System.out.println("학생 학번 정보 확인! 학번 입력>");
		String searchNum = scan.next();
		
		for(int i=0; i<cnt; i++) {
			if(searchNum.equals(students[i].getNum())) { 
				students[i].stdPrint();
				students[i].subPrint();
				return i;
			}
		}
		System.out.println("검색한 학번이 없습니다.");
		return -1;
	}

	@Override
	public void modifyStudent(Scanner scan) {
		// 학생정보 수정 : 이름이나 학번을 검색하여 주소,전화번호 수정
		System.out.println("수정할 학생의 정보(이름/학번)");
		String searchN = scan.next();  //name 이나 num 입력
		for(int i=0; i<cnt; i++) {
			String check = "n";
			if(students[i].getName().equals(searchN) || students[i].getNum().equals(searchN)) {
				System.out.println("수정할 정보");
				//주소수정
				System.out.println("주소(y/n)");
				check = scan.next();
				if(check.equals("y")) {
					System.out.println("수정할 주소 입력 >");
					String addr = scan.next();					
					students[i].setAddr(addr);
				}
				//전화번호수정
				System.out.println("전화번호(y/n)");
				check = scan.next();
				if(check.equals("y")) {
					System.out.println("수정할 전화번호 입력 >");
					String phone = scan.next();
					students[i].setPhone(phone);
				} 
				return;
			}	
		}
		System.out.println("학생을 찾을 수 없습니다.");
		System.out.println();
	}

	@Override
	public void deleteStudent(Scanner scan) {
		// 학생 삭제
		System.out.println("삭제할 학생의 이름 입력 >");
		String deleteName = scan.next();
		int index = -1; //없는 번지를 기본값으로 설정
		for(int i=0; i<cnt; i++) {
			if(students[i].getName().equals(deleteName)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("검색한 학생이 없습니다.");
			return;
		}
		int copyCnt = students.length - index - 1 ;
		System.arraycopy(students, index+1, students, index, copyCnt);
		
		students[students.length-1] = null;
		cnt--;
		
		System.out.println();
	}

	@Override
	public void registerSubject(Scanner scan) {
		// 수강신청
		// 수강과목의 정보를 입력받아 subject 객체를 생성하여 Student 클래스의 강의추가 메서드 호출
		
		int index = searchStudent(scan);

		System.out.println("수강할 정보를 입력해주세요");
		System.out.print("과목코드 : ");
		String code = scan.next();		
		System.out.print("과목명 : ");
		String subjectName = scan.next();		
//		System.out.print("학점 : ");
//		String point = scan.next();		
//		System.out.print("시수 : ");
//		String time = scan.next();		
//		System.out.print("교수명 : ");
//		String professor = scan.next();		
//		System.out.print("시간표 : ");
//		String timetable = scan.next();		
//		System.out.print("강의장 : ");
//		String room = scan.next();	
		System.out.println();
		
		//객체 생성 후 메서드 호출
		Subject subjectInfo = new Subject(code,subjectName);
	    students[index].insertSubject(subjectInfo);
	
	    System.out.println();
	}
	/* 과목코드   과목명    학점  시수  교수명  시간표  	 강의장
	 * msc001  대학수학    3	  3		가	  월수   A동301호
	 * msc002  공학수학    2	  2		나	  월목	B동302호
	 * com001  컴퓨터개론   2	  3		다	  화목	B동205호
	 * com002  운영체제    3	  3		라	 화수금	B동301호
	 * abc001  생활영어    2	  2		마	  화		A동203호
	 * */

	@Override
	public void deleteSubject(Scanner scan) {
		// 수강철회
		// 삭제할 수강코드를 입력받아 Student 클래스의 강의 삭제 메서드 호출
		int index = searchStudent(scan);
		
		//수강과목이 없다면 받지 않기.
		if(students[index].getCnt()!=0) {
			System.out.println("그럼 철회할 과목코드이 뭐야?");
			String searchCourse = scan.next();
			students[index].removeSubject(searchCourse);	
			System.out.println(searchCourse +"과목 수강철회 완료!");
		}
		System.out.println();
	}

	public Student[] getstudents() {
		return students;
	}

	public void setstudents(Student[] students) {
		this.students = students;
	}
	
}

