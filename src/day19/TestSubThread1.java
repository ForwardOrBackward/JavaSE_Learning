package day19;

class SubThread1 extends Thread{
	SubThread1(String name){
		super(name);
	}
	@Override
	public void run() {
		for(int i = 1; i <= 3; i++) {
			System.out.println(Thread.currentThread() + "," +i);
		}
	}
}
public class TestSubThread1 {

	public static void main(String[] args) {
		//����һ���߳� 
		//�½�
		SubThread1 t1 = new SubThread1("t1");
		//2.����һ���߳�
		t1.start();//������start��������һ��

		

	}

}
