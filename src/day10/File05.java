package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File05 {

	public static void main(String[] args) throws IOException {
		// test.txt 파일을 읽여들여 map에 저장
		// 명단, 합계, 평균 출력
		// 읽어 들이는 파일은 모두 String
		// 계산을 위해서는 int 로 변환이 필요
		// Integer.parseInt();
		// 80점 이상인 학생 명단
		
		HashMap<String, Integer> map = new HashMap<>();
		BufferedReader br = 
				new BufferedReader(new FileReader("test.txt"));
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			String[] test = line.split(" ");	
			String name = test[0];
			int score = Integer.parseInt(test[1]);
			map.put(name, score);
		}
		
		int sum = 0;
		double avg = 0;
		
		System.out.println("--명단--");
		for(String key : map.keySet()) {
			sum += map.get(key);
			System.out.println(key+":"+map.get(key));
		}
		System.out.println("________________");
		System.out.println();
		avg = (double)sum/map.size();
		System.out.println(String.format("합계:%d, 평균:%.2f", sum ,avg));
		
		System.out.println("________________");
		System.out.println();
		System.out.println("--80점 이상--");
		for(String name : map.keySet()) {
			if(map.get(name)>=80) {
				System.out.println(name+":"+map.get(name));
			}
		}
		
		br.close();
	}
	

}
