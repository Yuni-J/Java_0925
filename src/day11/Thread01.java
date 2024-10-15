package day11;

public class Thread01 {

	public static void main(String[] args) {
		/* Thread(쓰레드) : 실제 작업을 수행하는 단위
		 * - 프로그램이 실행되면 OS로부터 메모리를 할당 받아 process 의 상태가 됨.
		 * - 하나의 process 는 하나 이상의 Thread 를 가지게 됨.
		 * - Thread 는 실제 작업을 수행하는 단위이다.
		 * - thread 가 실제 CPU가 작업을 처리하는 단위
		 * - multi-thread : 여러개의 thread 가 동시에 수행되는 프로그램
		 * - CPU는 시간을 잘게 쪼개서 thread 를 번갈아 수행함. (시분할 처리)
		 * - 사용자들은 동시에 처리되는 듯한 효과를 가지게 됨.
		 * - thread 는 각자 자신만의 작업공간을 가짐 (context)
		 * - 각 thread 는 공유하는 자원이 있을 수 있음. (자바에서는 static instance)
		 * - 여러 thread 가 공유하는 자원을 사용하려고 경쟁이 발생함.
		 * - 경쟁이 발생하는 구역 critical section(임계영역)
		 * - 임계영역에서 교착상태가 발생하지 않도록 동기화(순차적 수행) 구현하여 오류를 막음. 
		 * */
		/* Thread 를 구현하는 2가지 방법
		 * 1. Thread 클래스를 상속하여 만들기
		 * 2. Runnable 인터페이스를 구현하여 만들기
		 * 자바는 다중상속을 허용하지 않기 때문에, 다른 클래스를 상속 중이라면 2번으로 구현
		 * */
		
		// 현재 실행 중인 쓰레드 이름
		System.out.println(Thread.currentThread().getName());

		MyThread th = new MyThread();
		th.start(); //run() 메서드 실행
		
		MyThread th2 = new MyThread();
		th2.start();
		
		System.out.println(("thread end!!"));
	}

}

class MyThread extends Thread{

	// 반드시 run() 이라는 메서드를 구현해야 함.
	@Override
	public void run() {
		// 0~500까지 반복하여 실행하는 구문수행
		for(int i=0; i<=500; i++) {
			System.out.println(i+"번째 Thread > "+ getName());
		}

	}
	
}



