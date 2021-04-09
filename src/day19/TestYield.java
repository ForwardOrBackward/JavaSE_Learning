package day19;

import java.util.Comparator;

class Thread2 implements Runnable{
	public void run() {
		for(int i = 1; i <= 10 ; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			if( i == 5 && Thread.currentThread().getName().equals("t1")) {
					Thread.yield();
			}
		}
	}
}
public class TestYield {

	public static void main(String[] args) {
		Thread2 th = new Thread2();
		Thread t1 = new Thread(th,"t1");
		Thread t2 = new Thread(th,"t2");
		t1.start();
		t2.start();

	}

}

