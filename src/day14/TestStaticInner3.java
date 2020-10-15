package day14;


class Outer1{
	//实例内部类,归外部类的对象所有
	class Inner1{
	}
}
/*
 * 继承实例内部类。
 * 但需要注意的是当Demo1需要创建对象时, 需要先调用父类Inner1的构造,而因为父类是一个实例
 * 内部类,是归外部类Outer的对象所有的,所以说调用Inner1的构造器时需要有一个外部类Outer1
 * 的对象才能创建
 */
class Demo1 extends Outer1.Inner1{
	Demo1(Outer1 outer1){
		outer1.super();//利用外部类对象调用 实例内部类的构造A
	}
}
public class TestStaticInner3 {
	public static void main(String[] args) {
		Outer1 outer1 = new Outer1();
		Demo1 demo = new Demo1(outer1);
	}

}
