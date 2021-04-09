package day20;

class Thread1 implements Runnable{
	int i = 10;
	//this
	synchronized public void run() {
		for(; i >= 0; i--) {
			if( i == 5 && Thread.currentThread().getName().equals("t1")) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(Thread.currentThread().getName()+":" + i);
		}
	}
}
public class TestWait {
	public static void main(String[] args) {
		Thread1 th = new Thread1();
		Thread t1 = new Thread(th,"t1");
		Thread t2 = new Thread(th,"t2");
		t1.start();
		t2.start();

	}

}
