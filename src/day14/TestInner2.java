package day14;

class Outer{
	int x = 11;//1
	class Inner{
		int x = 22;//2
		public void show() {
			int x = 33;//3
			//����ͬ�������ķ�������,�����������ȼ�
			System.out.println(x + "," + this.x +"," + Outer.this.x);//33,22,11
			System.out.println(x + "," + Inner.this.x +"," + Outer.this.x);//33,22,11
		}
	}
}
public class TestInner2 {
	public static void main(String[] args) {
		Outer.Inner inner = new Outer().new Inner();
		inner.show();//

	}

}
