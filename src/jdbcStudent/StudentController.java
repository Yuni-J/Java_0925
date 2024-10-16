package jdbcStudent;

import java.util.List;
import java.util.Scanner;

public class StudentController {
	/* Controller <-> Service <-> DAO <-> DB : 기본 클래스의 구조
	 * Controller 모든 메뉴 분기처리
	 * */
	
	private Scanner scan;
	private Service svc;  //interface
	private boolean flag;
	
	public StudentController() {
		scan = new Scanner(System.in);
		svc = new StudentServiceImpl();  //service 구현체
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println();
			System.out.println("--학생 관리 프로그램--");
			System.out.println("1.학생등록|2.학생리스트|3.학생검색(내정보보기)|"
					+ "4.내정보수정|5.학생삭제|6.종료");
			System.out.print("menu > ");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: register(); break;
			case 2: list(); break;
			case 3: search(); break;
			case 4: modify(); break;
			case 5: delete(); break;
			case 6: flag = false;
				System.out.println("종료!!");
				break;
			default: System.out.println("잘못된 메뉴입니다.");
			}
		}	
	}

	private void delete() {
		System.out.print("삭제할 학번를 입력 > ");
		String snum = scan.next();
		
		int isOk = svc.delete(snum);
		System.out.println("상품삭제 > "+(isOk > 0 ? "성공":"실패"));
		
	}

	private void modify() {
		System.out.print("수정할 학번를 입력 > ");
		String num = scan.next();
		System.out.println("학생 전화번호 : ");
		String phone = scan.next();
		System.out.println("학생 주소 : ");
		String addr = scan.next();
		
		Student s = new Student(num, phone, addr);
		int isOk = svc.update(s);
		System.out.println("학생 정보 수정 > "+(isOk > 0 ? "성공":"실패"));
		

		
	}

	private void search() {
		System.out.println("검색할 학번 입력 > ");
		String snum = scan.next();
		Student s = svc.searchStudent(snum);
		System.out.println(s);
		
	}

	private void list() {
		List<Student> list = svc.getList();
		// 출력
		for(Student s : list) {
			s.print();
		}
		
	}

	private void register() {
		// 학생 등록
		System.out.println("학생 이름 : ");
		String name = scan.next();
		System.out.println("학생 학번 : ");
		String num = scan.next();
		System.out.println("학생 생년월일 : ");
		String birth = scan.next();
		System.out.println("학생 전화번호 : ");
		String phone = scan.next();
		System.out.println("학생 주소 : ");
		String addr = scan.next();
		
		Student s = new Student(name, num, birth, phone, addr);
		
		int isOk = svc.insert(s);
		System.out.println("학생 등록 > "+(isOk > 0 ? "성공":"실패"));
	}
	
	

}
