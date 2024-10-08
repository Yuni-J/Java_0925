package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListEx02 {

	public static void main(String[] args) {
		// 두 배열을 하나의 리스트로 합치기
		// 정렬하여 출력 (오름, 내림차순)

		// Arrays.asList() : 배열 => 리스트
		// toArray() : 리스트 => 배열 
		
		String[] arr1 = {"a", "g", "f","h", "c"};
		String[] arr2 = {"b", "t", "s", "p","n", "m"};

		// 이건 내 방법ㅎㅎ
		List<String> list = new ArrayList<>();
		for(String a1 : arr1) {
			list.add(a1);
		}
		for(String a2 : arr2) {
			list.add(a2);
		}
		System.out.println(list);
		
		
		System.out.println("==방법 1==");
		// 방법 1. 직접 해당 값을 리스트로 올리기
		int cnt = arr1.length + arr2.length;
		int i=0, j=0;
		while(cnt>list.size()) {
			if(i>arr1.length) {
				list.add(arr1[i]);
				i++;
			}
			if(j>arr2.length) {
				list.add(arr1[j]);
				j++;
			}
		}
		System.out.println(list);
		
		System.out.println("==방법 2==");
		// 방법 2. Arrays.asList();
		List<String> list2 = Arrays.asList(arr1);
		System.out.println(list2);	
		// 배열과 list가 연결되어있는 상태 추가 불가능
		// 수정,추가 불가능, 원본 그대로 불러오기만 가능 
//		list2.add("z");
//		list2.add(0,"z");
//		System.out.println(list2);
		
		
		System.out.println("==new ArrayList==");
		List<String> list3 = new ArrayList<>(Arrays.asList(arr1));
		System.out.println(list3);
		list3.add("z");
		System.out.println(list3);
		
		System.out.println("==new ArrayList2==");
		List<String> list4 = new ArrayList<>(Arrays.asList(arr2));
		System.out.println(list4);
		
		System.out.println("==list addAll==");
		list3.addAll(list4);
		System.out.println(list3);
		
		// List를 배열로 변환
		System.out.println("--리스트를 배열로 변환--");
		int listSize = list3.size();
		String[] arr = list3.toArray(new String[listSize]);
		System.out.println(Arrays.toString(arr));
		
		
		
		System.out.println("--오름차순--");
		Collections.sort(list3);
		System.out.println(list3);

		System.out.println("--내림차순--");
		list3.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(list3);	

	}

}
