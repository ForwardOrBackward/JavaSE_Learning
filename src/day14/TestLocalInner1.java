package day14;

public class TestLocalInner1 {
	int num = 11;
	static int snum = 22;
	
	public void f() {
		int number = 11;//局部变量
//		number = 22;
		//局部内部类
		class Base{
			public void f() {
				System.out.println(num);
				System.out.println(snum);
				//可以访问，但是 局部变量的值不允许修改
				System.out.println(number);
			}
		}
	}
	public static void main(String[] args) {
		
		class Base{
			int x = 11;
			static final int n = 55;
			public void f() {
				//直接访问静态成员
				System.out.println(snum);
				System.out.println(new TestLocalInner1().num);
			}
		}
		class Sub extends Base{
			int y = 22;
		}

		Sub sub = new Sub();
		System.out.println(sub.x);
		System.out.println(sub.y);
	}

}
