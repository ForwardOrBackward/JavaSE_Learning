package day14;

class Parent{
	Parent(int n){
		System.out.println(n);
	}
	public void f() {}
}
public class TestNonameInner1 {
	Parent p = new Parent(45) {//�������
		public void f() {System.out.println("��дf");}
	};
	
	public static void main(String[] args) {
		TestNonameInner1 t = new TestNonameInner1();
		t.p.f();
//		t.p.func();//������صĹ��ܱ�������
//		Child child = new Child();
//		child.f();
		//���� �ڲ�  ���� :������������Ķ���
	/*	new Parent() {
			{
				
			}
			public void func() {}
			public void f() {System.out.println("child");}
		}.func();*/
	}

}
