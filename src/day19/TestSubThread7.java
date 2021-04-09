package day19;

class Zhangsan{
	public void say() {
		System.out.println("你给我书，我就给你画");
	}
	public void get() {
		System.out.println("张三获得了书");
	}
}
class Lisi{
	public void say() {
		System.out.println("你给我画，我就给你书");
	}
	public void get() {
		System.out.println("李四获得了画");
	}
}
class MyThread implements Runnable{
	static Zhangsan zhangsan = new Zhangsan();
	static Lisi lisi = new Lisi();
	boolean tag = false;
	public void run() {
		if(tag == true) {//张三
			synchronized (zhangsan) {
				zhangsan.say();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lisi) {
					zhangsan.get();
				}
			}
		}else {//李四
			synchronized (lisi) {
				lisi.say();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (zhangsan) {
					lisi.get();
				}
			}
		}
	}
}

public class TestSubThread7 {

	public static void main(String[] args) {
		MyThread my1 = new MyThread();
		my1.tag = true;
		MyThread my2 = new MyThread();
		my2.tag = false;
		
		Thread zhangsan = new Thread(my1);
		Thread lisi = new Thread(my2);
		
		zhangsan.start();
		lisi.start();

	}

}
