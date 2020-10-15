package day11;

interface IA{
	int N = 11;//public static final int N = 11;
	public default void df() {
		System.out.println("df");
	}
	static void sf() {//不能被 子接口或实现类继承
		System.out.println("sf");
	}
	void af();//
}
interface IB{
	int N = 22;
	static void sf() {
	}
	public default void df() {
		System.out.println("IB_df");
	}
	void af();
}
class DemoImpl implements IA,IB{
	//匿名内部类
	IA ia = new IA() {
		
		@Override
		public void af() {
			System.out.println("ia");
		}
	};
	IB ib = new IB() {
		
		@Override
		public void af() {
			System.out.println("ib");
		}
	};
	public void f() {
		System.out.println(IA.N);
		System.out.println(IB.N);
		IA.sf();
		IB.sf();
	}
	@Override
	public void df() {
//		IA.super.df();
		IB.super.df();
	}
	@Override
	public void af() {
		// TODO Auto-generated method stub
		
	}
}
class IAImpl implements IA{
	public void show() {
		
		System.out.println(N);
		df();
		IA.sf();
	}

	@Override
	public void af() {
		// TODO Auto-generated method stub
		
	}
}
public class TestInterface1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
