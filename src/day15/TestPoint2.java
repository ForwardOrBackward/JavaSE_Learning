package day15;

class Demo1{}
interface Ia{}
interface Ib{}
class Demo2 extends Demo1 implements Ia,Ib{}
class Point1<T extends Demo1 & Ia & Ib>{}
public class TestPoint2 {
	public static void main(String[] args) {
		//������
		Point1<?> p1 = new Point1<>();
		System.out.println(p1.getClass());;
		System.out.println(p1.toString());

	}

}
