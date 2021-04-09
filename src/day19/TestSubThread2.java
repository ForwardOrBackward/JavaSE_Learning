package day19;

class SubThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i <= 3; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
public class TestSubThread2 {

	public static void main(String[] args) {
		
		SubThread2 sub = new SubThread2();
		//创建一个线程
		Thread t1 = new Thread(sub,"t1");
		t1.start();
		Thread t2 = new Thread(sub,"t2");
		t2.start();
	}

}
