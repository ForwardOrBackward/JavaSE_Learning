package day14;

interface Info{
	public static class InnerDemo{
		int x = 11;
	}
	public static interface Ia{
		int N = 22;
		void af(); //定义了一个抽象方法
		default void df() {} //这个方法和现在那个方法有具体的实现,只不过是空实现
		static void sf() {} //静态方法,不能被子接口继承,也不能被其实现类实现。
	}
}
/*
 * 下面这个类直接实现的是Info的内部接口Ia,所以需要重写Ia的抽象方法。
 */
class IaImpl implements Info.Ia{
	@Override
	public void af() {
		System.out.println(N);
		df();//在实现了内部接口的类里,可以直接调用默认方法。而在下面的实现了外部接口的类里,就无法调用了。
		Info.Ia.sf();//静态方法没有被实现类实现,所以需要直接用接口名去调用
	}	
}
/*
 * 注意,下面这个类实现的是外部接口,也就是说内部接口的方法没有被实现,内部接口的抽象方法也不用重写
 */
class InfoImpl implements Info{
	public void show() {
		//x是实例成员,所以在别的类里需要创建对象才能访问
		System.out.println(new InnerDemo().x);
		//接口中(即使是内部接口)的变量默认是public static final的,所以变量N实际上是个静态常量
		System.out.println(Ia.N);
		//sf()方法是静态方法,可以直接调用。但需要注意的是这里可以省略Info外部接口不写。
		Ia.sf();//等价于Info.Ia.sf();
		//这个实现Info接口的类里无法直接调用Ia.df()方法,因为它是一个默认方法,非静态。		
		IaImpl ia = new IaImpl();//只能通过Ia接口的实现类创建对象来调用df()
		ia.df();
		
		//---------也可以用匿名内部类的方式调用df()------------------		
		new Info.Ia() {//这也是一个Ia接口的实现类的对象,只不过是匿名实现类
			@Override
			public void af() {				
			}
		}.df();
		//---------------------------------------------------
	}
}
public class TestStaticInner2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
