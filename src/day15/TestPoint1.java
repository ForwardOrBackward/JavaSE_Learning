package day15;

class Point11<T>{
	private T x;
	private T y;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	public void aa(Point11<T> p) {
		System.out.println(p);
	}
	
}
public class TestPoint1 {

	public static void main(String[] args) {
		//  具体类型参数：引用类型
		//参数化类型
		Point11<Integer> p1 = new Point11<Integer>();
		p1.setX(11);//int ->Integer ->Object
		p1.setY(22);
		p1.aa(p1);
		System.out.println(p1.getX() + "," + p1.getY());
		//类型推断   
		Point11<Double> p2 = new Point11<>();
		p2.setX(11.1);//double -> Double -> Object
		p2.setY(22.2);
		p2.aa(p2);
		System.out.println(p2.getX() + "," + p2.getY());
		Point11<String> p3 = new Point11<>();
		p3.setX("11c");//String -> Object
		p3.setY("22c");
		System.out.println(p3.getX() + "," + p3.getY());
		Point11<Object> p4 = new Point11<>();
		p4.setX(11.1);
		p4.setY(22.2);
		System.out.println(p4.getX() + "," + p4.getY());
		//只有一个泛型类
		System.out.println(p1.getClass());
		System.out.println(p2.getClass());
		System.out.println(p3.getClass());
		
		// p1-> Intger , p2->Doubel ,p3 ->String ,p4 -> Object
		TestPoint1 t = new TestPoint1();
//		t.f(p4);
	}
	public void ff(Point<? extends Object> o ,Point<String> s) {
		o = s;
	}
	//类型匹配
	public void f(Point11<?> p) {
		System.out.println(p.getX() + ":" + p.getY());
	}
	//只支持数字 Integer,Byte,Short ,Long ,Float,Double
	/*public void f(Point<? extends Number> p) {
		System.out.println(p.getX() + ":" + p.getY());
	}*/
	/*public void f(Point<? super Number> p) {
		System.out.println(p.getX() + ":" + p.getY());
	}*/
}
