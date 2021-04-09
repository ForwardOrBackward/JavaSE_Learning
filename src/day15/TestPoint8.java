package day15;

class Point<T>{}
class Demo5{
	public void f(int a){} //int
	public void f(int a,int b){} // int,int
	public void f(Point<String> p) {}// Point
	public <T> void f(T t) {}//Object
	public <T extends Demo1> void f(T t){}// Demo1
	public <T extends Ia & Ib> void f(T t) {}// Ia
	public <T extends Ib & Ia> void f(T t) {}// Ib
}
class Base1{
	public void f(Point<Object> p) {}//Point
	public <T> void ff(T t) {}
}
class Sub1 extends Base1{
	@Override
	public void f(Point<Object> p) {}
	@Override
	public void ff(Object t) {
		
	}
}


public class TestPoint8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
