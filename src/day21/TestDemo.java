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
public class TestDemo {//启动类，主类
/*	static {
		System.out.println("TestDemo");
	}*/
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//1.加载主类
		//2.创建了某个类的对象
//		Demo demo = new Demo();
		//3.调用静态成员(staic final 编译期能够确定值，不会引起类的初始化)
		System.out.println(Demo.sn);
		//4.创建子类对象，先初始化父类
//		SubDemo sub = new SubDemo();
		//5.
//		Class c  = new Demo().getClass();
//		Class c = Demo.class;
//		Object obj = c.newInstance();

	}

}
