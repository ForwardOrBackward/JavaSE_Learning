package day11;

abstract class TrafficTool{
	private int count ;
	public TrafficTool(int count) {// int count = 100;
		super();//Object 
		this.count = count;// this.count = 100;
	}
	public int getCount() {
		return count;
	}
	public  abstract  void run() ;//���󷽷� 
}
class Car1 extends TrafficTool{

	public Car1(int count) {// int count = 100;
		super(count);// 100
	}

	public void run() {
		System.out.println("�����ڹ�·����ʻ���ؿ�����" + getCount());
	}
	public void f() {}
	public void func() {}
}
public class TestTrafficTool {

	public static void main(String[] args) {
		//��������ת��
		//���� ����                            �������
		TrafficTool car = new Car1(100);
		car.run();
		//car.f();
		//car.func();
	}

}
