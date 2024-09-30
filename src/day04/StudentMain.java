package day04;

public class StudentMain {

	public static void main(String[] args) {

		Student s = new Student("hong", "000101", "010-1111-1111", "25", "incheon");
//		s.studentPrint();
//		s.academyPrint();
		s.addCourse("JAVA", "6개월");
		s.addCourse("Python", "1개월");
		s.addCourse("SQLD", "1개월");
//		s.coursePrint();
		
		Student s1 = new Student("kim", "020302", "010-1111-2222", "23", "seoul");
//		s1.studentPrint();
//		s1.academyPrint();
		s1.addCourse("JAVA", "6개월");
		s1.addCourse("React", "2개월");
//		s1.coursePrint();
		
		// 
		Student[] st = new Student[8];
		st[0] = s;
		st[1] = s1;

		// 6명 정보 추가
		st[2] = new Student("lee", "990726", "010-1111-3333", "26", "seoul");
		st[2].addCourse("Python", "4개월");
		st[2].addCourse("React", "3개월");	
		st[2].addCourse("JavaScript", "2개월");
		st[3] = new Student("pack", "030916", "010-1111-4444", "22", "incheon");
		st[3].addCourse("Python", "2개월");
		st[3].addCourse("JAVA", "3개월");		
		st[4]= new Student("jang", "001205", "010-1111-5555", "25", "incheon");
		st[4].addCourse("JAVA", "4개월");		
		st[5] = new Student("seo", "040508", "010-1111-6666", "21", "seoul");
		st[5].addCourse("HTML", "1개월");
		st[5].addCourse("JavaScript", "2개월");
		st[5].addCourse("React", "1개월");	
		st[6] = new Student("kang", "011028", "010-1111-7777", "24", "incheon");
		st[7] = new Student("ho", "030303", "010-1111-8888", "22", "seoul");
		st[7].addCourse("Python", "3개월");
		st[7].addCourse("React", "1개월");	

		
		
		System.out.println("---학생 전체 명단---");
		// 학생 전체 명단 출력 (학생 정보만...)
		for(Student stemp : st) {
			stemp.studentPrint();			
		}
		
		System.out.println("---------------------------");
		System.out.println("---hong 학생---");
		// hong 학생의 학생정보, 학원정보, 수강정보 출력
		String searchName = "hong";
		for(int i=0; i<st.length; i++) {
			if(st[i].getName().equals(searchName)) {
				st[i].studentPrint();
				st[i].academyPrint();
				st[i].coursePrint();
			}
		}
		
		System.out.println("---------------------------");
		System.out.println("---incheon 지점의 학생 명단---");
		// incheon 지점의 학생 명단 출력(학생 정보만)
		String searchAddr = "incheon";
		for(int i=0; i<st.length; i++) {
			if(st[i].getAddr() != null) {  //nullPointException 방지용
				if(st[i].getAddr().equals(searchAddr)) {
					st[i].studentPrint();
				}	
			}
		}
		
		System.out.println("---------------------------");
		System.out.println("---java 과목을 수강하는 학생명단---");		
		// java 과목을 수강하는 학생명단 출력(학생정보, 학원정보, 수강정보전부 출력)
		String searchSubject = "JAVA";	
		for(int i=0; i<st.length; i++) {
			if(st[i].subjectCheck(searchSubject)) {
				st[i].studentPrint();
				st[i].academyPrint();
				st[i].coursePrint();
				System.out.println("-------------");
			}
		}
		
		System.out.println("---------------------------");
		System.out.println("---수강하지 않는 학생 명단---");
		// 수강하지 않는 학생 명단 출력 (학생정보만)...
		for(int i=0; i<st.length; i++) {
			if(st[i].getCourseCount() == 0) {
				st[i].studentPrint();
			}
		}

	}

}
