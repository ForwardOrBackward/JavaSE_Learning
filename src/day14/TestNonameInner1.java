package day14;

class Parent{
	Parent(int n){
		System.out.println(n);
	}
	public void f() {}
}
public class TestNonameInner1 {
	Parent p = new Parent(45) {//子类对象
		public void f() {System.out.println("重写f");}
	};
	
	public static void main(String[] args) {
		TestNonameInner1 t = new TestNonameInner1();
		t.p.f();
//		t.p.func();//子类独特的功能被屏蔽了
//		Child child = new Child();
//		child.f();
		//匿名 内部  子类 :创建的是子类的对象
	/*	new Parent() {
			{
				
			}
			public void func() {}
			public void f() {System.out.println("child");}
		}.func();*/
	}

}
