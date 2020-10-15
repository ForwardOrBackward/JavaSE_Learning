package day14;

@FunctionalInterface
interface La<T>{
	int af(T n1, int n2);
	default void f() {		
	}	
}
class A implements La{
	
	@Override
	public int af(Object n1, int n2) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
}
class B extends A{
	void ff() {
		af("hello",2);
	}
}
public class TestLambda1 {
	//1.无参，无返回值
//	La la1 = ()->{System.out.println("af");};
	//一行代码，可以省略{}
//	La la2 = ()->System.out.println("af");
	
	//2。带参 ，不带返回值
//	La la3 = (n)->{System.out.println(n);};
	//参数 只有一个 ，可以省略（）
//	La la4 = n ->System.out.println(n);
	
	//3 无参，带返回值
//	La la5 = () -> {return 22;};
	//只有一行代码，是return 语句，可以省略return 
//	La la6 = () -> 22;
	
	//4.带参 ，带返回值类型
//	La la7 = (n1,n2) -> {return n1 + n2;};
//	La la8 = (n1,n2) -> n1 + n2;
	
	public static void main(String[] args) {
//		TestLambda1 t = new TestLambda1();
//		t.la1.af();
		
/*		new La() {
			public void af() {
				System.out.println("af");
			}
		}.af();*/

	}

}
