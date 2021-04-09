package day19;

class SubThread3 implements Runnable{
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + "吃饭" );
		}
	}
}
public class TestSubThread3 {

	public static void main(String[] args) {
		SubThread3 sub = new SubThread3();
		Thread  zhangsan = new Thread(sub,"张三");
		Thread lisi = new Thread(sub,"李四");
//		System.out.println(zhangsan.getPriority());
//		System.out.println(lisi.getPriority());
//		zhangsan.setPriority(1);
//		lisi.setPriority(10);

		zhangsan.start();
		lisi.start();
		//1
	/*	try {
			//  等待  (毫秒)
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//2. 判断 是否 还有 运行的线程
		if(zhangsan.isAlive() || lisi.isAlive()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//3.
	/*	try {
			zhangsan.join();
			lisi.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("主线程结束");

	}

}
