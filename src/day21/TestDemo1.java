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
		
		//加载一个类的两种方式(很少自己去加载一个类,了解即可)
		//1.只加载类,但不初始化。 也就意味着不会执行静态块里的语句
		//getSystemClassLoader()是获得一个系统类加载器, loadClass()方法则加载一个具体的类,类要用完全限定名称
		ClassLoader.getSystemClassLoader().loadClass("day21.Demo1");
		//2.加载 并且初始化。会执行静态块里的语句
		Class.forName("day21.Demo1");
	}

}
