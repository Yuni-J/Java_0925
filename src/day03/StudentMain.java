package day03;

public class StudentMain {

	public static void main(String[] args) {
		Student s = new Student("incheon","홍길동");
		//print() 메서드를 호출
//		s.print();
		s.setCourse("JAVA");
		s.setPhone("010-1234-5678");
//		s.print();
		
//		System.out.println(s);  //자동으로 toString 호출
		
		
		Student s1 = new Student("incheon","김순이","AWS","010-1111-1111");
//		s1.print();
		
		//toString이 없으면 객체의 주소가 출력 => day03.Student@668bc3d5
//		System.out.println(s1);
		Student s2 = new Student("incheon","김영철","JAVA","010-1111-2222");
		Student s3 = new Student("seoul","이순이","AWS","010-1111-3333");
		Student s4 = new Student("incheon","박송이","AWS","010-1111-4444");
		Student s5 = new Student("seoul","최순철","JAVA","010-1111-5555");
		
		Student[] studentArr = new Student[6];
		studentArr[0] = s;
		studentArr[1] = s1;
		studentArr[2] = s2;
		studentArr[3] = s3;
		studentArr[4] = s4;
		studentArr[5] = s5;

		// 전체 학생명단 출력
		for(Student stemp : studentArr) {
			stemp.print();
//			System.out.println(stemp);
		}
		
		System.out.println("---이름찾기----------------------------");
		// 홍길동의 정보를 출력   == 안됨.
		// equals() : String 값이 값은지 확인하는 메서드
		String searchName = "홍길동";
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i].getName().equals(searchName)) {
				System.out.println(studentArr[i]);
			}
		}
		for(Student sn : studentArr) {
			if(sn.getName().equals(searchName)) {
				System.out.println(sn);
			}
		}
		
		System.out.println("---지점찾기----------------------------");
		// incheon 지점 학생들 명단 출력
		// 학생이 없다면 명단이 없습니다. 출력
		int count = 0;
		String searchAddr = "incheon";
		for(Student sa : studentArr) {
			if(sa.getAddr().equals(searchAddr)) {
				System.out.println(sa);
				count++;
			} 
		}
		if(count == 0) {
			System.out.println("명단에 없습니다.");
		}
		
		System.out.println("---과정바꾸기---------------------------");
		// 홍길동의 course를 AWS로 변경 => 출력
		String changeCourse = "홍길동";
		for(Student cc : studentArr) {
			if(cc.getName().equals(changeCourse)) {
				cc.setCourse("AWS");
				System.out.println(cc);	
			}
		}

	}

}
