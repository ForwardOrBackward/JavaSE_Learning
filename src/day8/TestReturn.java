package day8;


public class TestReturn {
	public int f(int n){
		if (n==0)
			return 1;
		return n*f(n-1);
	}
	public static void main(String[] args) {
		TestReturn t = new TestReturn();
		System.out.println(t.f(2));
	}
}
