package day19;

class Zhangsan{
	public void say() {
		System.out.println("������飬�Ҿ͸��㻭");
	}
	public void get() {
		System.out.println("�����������");
	}
}
class Lisi{
	public void say() {
		System.out.println("����һ����Ҿ͸�����");
	}
	public void get() {
		System.out.println("���Ļ���˻�");
	}
}
class MyThread implements Runnable{
	static Zhangsan zhangsan = new Zhangsan();
	static Lisi lisi = new Lisi();
	boolean tag = false;
	public void run() {
		if(tag == true) {//����
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
		}else {//����
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
