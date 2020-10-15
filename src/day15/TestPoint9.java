package day15;

interface Info<T>{
	void f(T t);
}
class InfoImpl1 implements Info<String>{
	@Override
	public void f(String t) {
	}	
}
class InfoImpl2<T> implements Info<T>{
	@Override
	public void f(T t) {
	}
	
}
public class TestPoint9 {

	public static void main(String[] args) {
		InfoImpl2<String> info = new InfoImpl2<>();

	}

}
