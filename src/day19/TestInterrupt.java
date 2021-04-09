package day19;

class Thread1 implements Runnable{
	public void run() {
		for(int i = 1; i <= 10 ; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			if( i == 5) {
				try {
//					Thread.sleep(2000);
					Thread.currentThread().join();
				} catch (InterruptedException e) {
					System.out.println("进入异常处理阶段");
				}
			}
		}
	}
}
public class TestInterrupt {
	public static void main(String[] args) {
		Thread1 th = new Thread1();
		Thread t1 = new Thread(th);
		t1.start();
		t1.interrupt();//t1中断

	}

}
