package day21;

class Demo{
	static int n = 22;
	static final int sn = 11 + n;//
	static{
		
		System.out.println("Demo _static");
	}
	
}
class SubDemo extends Demo{
	static {
		System.out.println("subDemo _ static");
	}
}
public class TestDemo {//�����࣬����
/*	static {
		System.out.println("TestDemo");
	}*/
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//1.��������
		//2.������ĳ����Ķ���
//		Demo demo = new Demo();
		//3.���þ�̬��Ա(staic final �������ܹ�ȷ��ֵ������������ĳ�ʼ��)
		System.out.println(Demo.sn);
		//4.������������ȳ�ʼ������
//		SubDemo sub = new SubDemo();
		//5.
//		Class c  = new Demo().getClass();
//		Class c = Demo.class;
//		Object obj = c.newInstance();

	}

}
