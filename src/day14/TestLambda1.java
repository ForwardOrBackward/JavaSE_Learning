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
	//1.�޲Σ��޷���ֵ
//	La la1 = ()->{System.out.println("af");};
	//һ�д��룬����ʡ��{}
//	La la2 = ()->System.out.println("af");
	
	//2������ ����������ֵ
//	La la3 = (n)->{System.out.println(n);};
	//���� ֻ��һ�� ������ʡ�ԣ���
//	La la4 = n ->System.out.println(n);
	
	//3 �޲Σ�������ֵ
//	La la5 = () -> {return 22;};
	//ֻ��һ�д��룬��return ��䣬����ʡ��return 
//	La la6 = () -> 22;
	
	//4.���� ��������ֵ����
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
