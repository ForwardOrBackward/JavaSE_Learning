package day20;

class Qingfeng{  //清风包子铺
	private int count;//包子的个数
	private boolean tag = false;// true包子铺当前有包子,false包子铺当前没有包子
	//厨师生产包子 
	synchronized public void put(int count) { 
		if(tag == true) { //有包子, 厨师就不用生产,等包子卖完
			try {
				wait();//等
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//没包子了, 厨师开始生产包子。
		this.count = count;
		tag = true;
		System.out.println("生产了：" + this.count);
		notify();//包子生产完, 唤醒销售人员
	}
	//销售人员卖包子
	synchronized public void get() {
		if(tag == false) {//没包子了, 销售人员就不用卖了,等包子生产好
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//有包子了,销售人员开始销售包子。
		System.out.println("卖了：" + this.count);
		tag = false;
		notify();//包子卖完了, 唤醒厨师
	}
}
class Producer implements Runnable{ //定义生产者(厨师)线程
	private Qingfeng qingfeng;
	Producer(Qingfeng qingfeng){
		this.qingfeng = qingfeng;
	}
	public void run() {
		for(int i = 1; i <= 5; i++) {
			qingfeng.put(i);
		}
	}
}
class Consumer implements Runnable{//定义消费者(销售人员)线程
	private Qingfeng qingfeng;
	Consumer(Qingfeng qingfeng){
		this.qingfeng = qingfeng;
	}
	public void run() {
		for(int i = 1; i <= 5; i++) {
			qingfeng.get();
		}
	}
}
public class TestWait2 {

	public static void main(String[] args) {
		Qingfeng qingfeng = new Qingfeng();
		Producer p = new Producer(qingfeng);
		Consumer c = new Consumer(qingfeng);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();

	}

}
