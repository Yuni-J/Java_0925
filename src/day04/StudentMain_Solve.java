package day04;

public class StudentMain_Solve{

	public static void main(String[] args) {
		Student_Solve s = new Student_Solve();
		s.setName("홍길동");
		s.setPhone("010-1111-1111");
//		s.printInfo();
//		s.printCompany();
//		s.printCourse();
		
		Student_Solve s1 = new Student_Solve("hong","010-111-2222","incheon");
//		s1.printInfo();
//		s1.printCompany();
		s1.insertCourse("java", "5 Month");
		s1.insertCourse("python", "1 Month");
//		s1.printCourse();
		
		Student_Solve s2 = new Student_Solve("pack", "010101", "010-2222-2222", "25", "incheon");
//		s2.printInfo();
//		s2.printCompany();
		s2.insertCourse("java", "5 Month");
		s2.insertCourse("HTML", "1 Month");
		s2.insertCourse("React", "1 Month");
//		s2.printCourse();
		
		Student_Solve[] std = new Student_Solve[8];
		std[0]=s;
		std[1]=s1;
		std[2]=s2;
		
		// 5명 정보를 추가
		std[3] = new Student_Solve("kim", "010202", "010-2222-3333", "25", "seoul");
		std[3].insertCourse("java", "5 Month");
		std[3].insertCourse("HTML", "1 Month");
		std[4] = new Student_Solve("choi", "020206", "010-2222-3333", "24", "seoul");
		std[4].insertCourse("python", "1 Month");
		std[4].insertCourse("React", "1 Month");
		std[5] = new Student_Solve("lee", "030205", "010-2222-3333", "23", "incheon");
		std[5].insertCourse("java", "5 Month");
		std[5].insertCourse("HTML", "1 Month");
		std[5].insertCourse("React", "1 Month");
		std[6] = new Student_Solve("kang", "040207", "010-2222-3333", "22", "seoul");
		std[7] = new Student_Solve("hi", "050205", "010-2222-3333", "21", "incheon");
		std[7].insertCourse("React", "3 Month");
		std[7].insertCourse("python", "1 Month");
		
		// 학생 전체 명단 출력 (학생정보만..)
		System.out.println("--학생전체명단--");
		for(int i=0; i<std.length; i++) {
			std[i].printInfo();
		}
		System.out.println("------------------------------");
		
		// hong 학생의 학생정보, 학원정보, 수강정보 출력
		String searchName = "hong";
		for(int i=0; i<std.length; i++) {
			if(std[i].getName().equals(searchName)) {
				std[i].printInfo();
				std[i].printCompany();
				std[i].printCourse();
			}
		}
		
		
		
		// incheon 지점의 학생 명단 출력 (학생정보만..)
		String searchBranch = "incheon";
		System.out.println("---"+searchBranch+"지점 검색정보---");
		for(int i=0; i<std.length; i++) {
			if(std[i].getBranch() != null) {  //nullPointException 방지용
				if(std[i].getBranch().equals(searchBranch)) {
					std[i].printInfo();
					std[i].printCompany();
				}				
			}
		}
		
		System.out.println("------------------------------");
		
		// java 과목을 수강하는 학생명단 출력(학생정보, 학원정보, 수강정보전부 출력)
		String searchCourse = "java";
		System.out.println("---"+searchCourse+"과목 수강학생 정보---");
		//전체 학생 배열에서 개개인의 과목 배열로 2중 검색
		int cnt=0;
		while(cnt < std.length) {
			for(int i=0; i<std[cnt].getCourse().length; i++) {
				if(std[cnt].getCourse()[i] != null) {
					if(std[cnt].getCourse()[i].equals(searchCourse)) {
						std[cnt].printInfo();
						std[cnt].printCompany();
						std[cnt].printCourse();
					}
				}
			}
			cnt++;
		}
//	    // 각 학생의 수강 과목을 확인
//	    for (int i = 0; i < st[cnt].getCourseCount(); i++) {
//	        // 과목이 null이 아니고, 과목명이 검색어와 일치하는지 확인
//	        if (st[cnt].getCourses()[i] != null) {
//	            if (st[cnt].getCourses()[i].getSubject().equals(searchSubject)) {
//	                st[cnt].studentPrint();
//	                st[cnt].academyPrint();
//	                st[cnt].coursePrint();
//	            }
//	        }
//	    }
//	}
		
		// 수강하지 않는 학생 명단 출력 (학생정보만)..
		System.out.println("---수강과목이 없는 학생 정보---");
		cnt=0;
		while(cnt < std.length) {
			if(std[cnt].getCourse()[0] == null) {
				std[cnt].printInfo();
			}
			cnt++;
		}
	}
	
}

