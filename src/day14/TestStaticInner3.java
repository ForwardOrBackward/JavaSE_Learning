package day14;


class Outer1{
	//ʵ���ڲ���,���ⲿ��Ķ�������
	class Inner1{
	}
}
/*
 * �̳�ʵ���ڲ��ࡣ
 * ����Ҫע����ǵ�Demo1��Ҫ��������ʱ, ��Ҫ�ȵ��ø���Inner1�Ĺ���,����Ϊ������һ��ʵ��
 * �ڲ���,�ǹ��ⲿ��Outer�Ķ������е�,����˵����Inner1�Ĺ�����ʱ��Ҫ��һ���ⲿ��Outer1
 * �Ķ�����ܴ���
 */
class Demo1 extends Outer1.Inner1{
	Demo1(Outer1 outer1){
		outer1.super();//�����ⲿ�������� ʵ���ڲ���Ĺ���A
	}
}
public class TestStaticInner3 {
	public static void main(String[] args) {
		Outer1 outer1 = new Outer1();
		Demo1 demo = new Demo1(outer1);
	}

}
