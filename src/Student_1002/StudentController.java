package Student_1002;

import java.util.Scanner;

public class StudentController implements Program {
	// StudnetController 가 구현
	// - Student class 배열처리
	
	//맴버변수 추가
	private Student[] menu = new Student[5];
	private int cnt; 

	
	Student s = new Student();

	
	@Override
	public void insertStudent(Scanner scan) {
		// 학생등록
		//배열 늘려주기
		if(cnt == menu.length) {
			Student[] temp = new Student[menu.length+5];
			//배열복사
			System.arraycopy(menu, 0, temp, 0, cnt);
			menu = temp;
		}
		System.out.println("학생을 등록하시오(이름/학번/과목/주소/나이/전화번호)");
		System.out.print("학생 이름 : ");
		String name = scan.next();
		System.out.print("학번 : ");
		String num = scan.next();
		System.out.print("주소 : ");
		String addr = scan.next();
		System.out.print("나이 : ");
		String age = scan.next();
		System.out.print("전화번호 : ");
		String phone = scan.next();	
		System.out.println();
		
		Student studentInfo = new Student(name,num,addr,age,phone);
		menu[cnt] = studentInfo;
		cnt++;
	}

	@Override
	public void printStudent() {
		// 학생정보 출력
		System.out.println("--학생 리스트 출력--");
		for(int i=0; i<cnt; i++) {
			System.out.println(menu[i]);
		}
		if(cnt == 0) {
			System.out.println("등록된 학생이 없습니다.");
		}
		System.out.println();
	}

	@Override
	public void searchStudent(Scanner scan) {
		// 학생검색(학생정보, 수강정보)
//		System.out.println("학생 정보 확인! 학생 이름 입력>");
//		String searchName = scan.next();
//		for(int i=0; i<cnt; i++) {
//			
//		}
		
	}

	@Override
	public void modifyStudent(Scanner scan) {
		// 학생정보 수정 : 이름이나 학번을 검색하여 주소,전화번호 수정
		System.out.println("수정할 학생의 정보(이름/학번)");
		String searchN = scan.next();  //name 이나 num 입력
		for(int i=0; i<cnt; i++) {
			String check = "n";
			if(menu[i].getName().equals(searchN) || menu[i].getNum().equals(searchN)) {
				System.out.println("수정할 정보");
				//주소수정
				System.out.println("주소(y/n)");
				check = scan.next();
				if(check.equals("y")) {
					System.out.println("수정할 주소 입력 >");
					String addr = scan.next();					
					menu[i].setAddr(addr);
				}
				//전화번호수정
				System.out.println("전화번호(y/n)");
				check = scan.next();
				if(check.equals("y")) {
					System.out.println("수정할 전화번호 입력 >");
					String phone = scan.next();
					menu[i].setPhone(phone);
				} 
				return;
			}	
		}
		System.out.println("학생을 찾을 수 없습니다.");
	}

	@Override
	public void deleteStudent(Scanner scan) {
		// 학생 삭제
		System.out.println("삭제할 학생의 이름 입력 >");
		String deleteName = scan.next();
		int index = -1; //없는 번지를 기본값으로 설정
		for(int i=0; i<cnt; i++) {
			if(menu[i].getName().equals(deleteName)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("검색한 학생이 없습니다.");
			return;
		}
		int copyCnt = menu.length - index - 1 ;
		System.arraycopy(menu, index+1, menu, index, copyCnt);
		
		menu[cnt-1] = null;
		cnt--;
	}

	@Override
	public void registerSubject(Scanner scan) {
		// 수강신청
		System.out.println("누가 수강신청 할꺼야??");
		String name = scan.next();
		System.out.println("수강할 정보를 입력해주세요");
		System.out.println("과목코드 : ");
		String code = scan.next();		
		System.out.println("과목명 : ");
		String subjectName = scan.next();		
		System.out.println("학점 : ");
		String point = scan.next();		
		System.out.println("시수 : ");
		String time = scan.next();		
		System.out.println("교수명 : ");
		String professor = scan.next();		
		System.out.println("시간표 : ");
		String timetable = scan.next();		
		System.out.println("강의장 : ");
		String room = scan.next();		
		
//		public Subject(code,subjectName,point,time,professor,timetable,room)
		
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
		
	}

}
