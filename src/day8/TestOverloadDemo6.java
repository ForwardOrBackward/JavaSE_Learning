package day8;

public class TestOverloadDemo6 {

	public void f() {
		System.out.println("f");
	}
	public void f(int n) {
		System.out.println("int");
	}
	public void f(byte n) {
		System.out.println("byte");
	}
	public void f(short n) {
		System.out.println("short");
	}
	public void f(long n) {
		System.out.println("long");
	}
	public void f(char n) {
		System.out.println("char");
	}
	public void f(float n) {
		System.out.println("float");
	}
	public void f(double n) {
		System.out.println("double");
	}
	public void f(int n1, double n2) {// double n2 = 22;// int -> double
		System.out.println("int _ double");
	}
	public void f(double n1, int n2) {// double n1 = 11; // int -> double
		System.out.println("double _ int");
	}
	public static void main(String[] args) {
		TestOverloadDemo6 t = new TestOverloadDemo6();
		
		
		
//		t.f(22);// int 
//		t.f((byte)22);//byte
//		t.f(22L);//long
//		t.f(11.1);//double
		t.f(11.1f);// float
//		t.f(11,11.1);//int_double
//		t.f(11.1,11);//double_int
//		t.f(11,22);//不能产生歧义

	}

}
