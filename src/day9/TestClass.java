package day9;

public class TestClass {
	private int a = 3;
	public static void main(String[] args) {
		
	}
	class Inner {
		private int data = 1;
		public void show(){
			data = data + a;
			System.out.println(data);
		}
	}
}
