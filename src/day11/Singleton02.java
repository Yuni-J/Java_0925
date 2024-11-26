package day11;

class Counter{
	// 싱글톤으로 생성
	private int count;
	//내 객체를 저장하는 멤버변수 (static)
	private static Counter instance;
	
	// 생성자 private
	private Counter() {}
	
	// 인스턴스를 1개만 생성해주는 메서드
	public static Counter getInstance() {
		if(instance == null) {
			instance = new Counter();
		}
		return instance;	
	}
	
	// count가 하나 올라가는 메서드 생성 countMethod()
	public int countMethod() {
		count++;
		return this.count;
	}
	
}
public class Singleton02 {

	public static void main(String[] args) {
		// Counter 객체를 2개 생성하여 각각 countMethod() 호출
		// 1개의 객체가 공유되기 때문에 1개의 변수만 변화
		
		Counter c = Counter.getInstance();
		Counter c1 = Counter.getInstance();
		

		System.out.println("cCounter : "+c.countMethod());	
		System.out.println("c1Counter : "+c1.countMethod());
		System.out.println("cCounter : "+c.countMethod());	
		System.out.println("cCounter : "+c.countMethod());	
		System.out.println("c1Counter : "+c1.countMethod());
		System.out.println("c1Counter : "+c1.countMethod());
		// 결론 => 하나의 객체를 공유해서 사용하고 있다.
	}

}
