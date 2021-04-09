package day21;

class Demo1{
	static {
		System.out.println("staticDemo1");
	}
}
public class TestDemo1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Demo1 demo = new Demo1();
		ClassLoader loader = demo.getClass().getClassLoader();
		
		System.out.println(loader);//sun.misc.Launcher$AppClassLoader@2a139a55
		
		System.out.println(loader.getParent());//sun.misc.Launcher$ExtClassLoader@7852e922
		
		System.out.println(loader.getParent().getParent());//null   
		
		//����һ��������ַ�ʽ(�����Լ�ȥ����һ����,�˽⼴��)
		//1.ֻ������,������ʼ���� Ҳ����ζ�Ų���ִ�о�̬��������
		//getSystemClassLoader()�ǻ��һ��ϵͳ�������, loadClass()���������һ���������,��Ҫ����ȫ�޶�����
		ClassLoader.getSystemClassLoader().loadClass("day21.Demo1");
		//2.���� ���ҳ�ʼ������ִ�о�̬��������
		Class.forName("day21.Demo1");
	}

}
