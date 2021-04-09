package day20;

class Qingfeng{  //��������
	private int count;//���ӵĸ���
	private boolean tag = false;// true�����̵�ǰ�а���,false�����̵�ǰû�а���
	//��ʦ�������� 
	synchronized public void put(int count) { 
		if(tag == true) { //�а���, ��ʦ�Ͳ�������,�Ȱ�������
			try {
				wait();//��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//û������, ��ʦ��ʼ�������ӡ�
		this.count = count;
		tag = true;
		System.out.println("�����ˣ�" + this.count);
		notify();//����������, ����������Ա
	}
	//������Ա������
	synchronized public void get() {
		if(tag == false) {//û������, ������Ա�Ͳ�������,�Ȱ���������
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//�а�����,������Ա��ʼ���۰��ӡ�
		System.out.println("���ˣ�" + this.count);
		tag = false;
		notify();//����������, ���ѳ�ʦ
	}
}
class Producer implements Runnable{ //����������(��ʦ)�߳�
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
class Consumer implements Runnable{//����������(������Ա)�߳�
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
