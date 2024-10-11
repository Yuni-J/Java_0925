package day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListEx01 {

	public static void main(String[] args) {
		/* 하루 일과를 저장하는 list를 생성
		 * 출력 for / 향상된 for / Iterator 출력
		 * import 단축키 : ctrl + shift + o
		 * */ 
		
		List<String> todayList = new ArrayList<String>();
		todayList.add("양치하기");
		todayList.add("학원 갈 준비하기");
		todayList.add("잠자기");
		todayList.add("티비보기");
		todayList.add("밥먹기");
		todayList.add("공부하기");
		System.out.println(todayList);
		
		System.out.println("--출력 for--");
		//출력 for
		for(int i=0; i<todayList.size(); i++) {
			System.out.println(todayList.get(i));
		}
		
		System.out.println("--향상된 for--");
		//향상된 for
		for(String today : todayList) {
			System.out.println(today);
		}
		
		System.out.println("--Iterator 출력--");
		//Iterator 출력
		Iterator<String> it = todayList.iterator();
		while(it.hasNext()) {
			String temp = it.next();
			System.out.println(temp);
		}
		
		// 정렬 list.sort(Comparator 구현체);
		//오름차순
		Collections.sort(todayList);
		System.out.println(todayList);
		//내림차순
		todayList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// compareTo
				// 사전순으로 앞에 있으면 -, 같으면 0, 뒤에 있으면 +
				// o1.compareTo(o2);  //오름차순
				// o2.compareTo(o1);  //내림차순
				return o2.compareTo(o1);  
			}
		});
		System.out.println(todayList);
		
		System.out.println("--remove--");
		//같은 Object가 2개 이상이더라도 앞에있는 하나만 삭제
		todayList.add("밥먹기");
		System.out.println(todayList);
		
		List<String> ex = new ArrayList<>();
		ex.add("밥먹기");
		todayList.removeAll(ex);
		System.out.println(todayList);

	}

}
