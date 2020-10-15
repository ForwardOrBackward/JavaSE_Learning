package day14;

class Base{
	class Inner{}
}
class Sub extends Base{
	/*
	 * 子类继承父类时,只有实例方法如果重写的话 会覆盖父类的方法,其他的成员如果有同名
	 * 的都不会覆盖父类的成员。
	 * 而内部类在继承后如果定义同名内部类,也不会覆盖父类中的 内部类。因为父类和子类的
	 * 内部类的字节码文件的文件名实际上是不一样的。父类内部类Inner的字节码文件名
	 * 为:Base$Inner.class, 而子类内部类Inner的字节码文件名为:Sub$Inner.class
	 */
	
	class Inner{}
}
public class TestStaticInner4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
