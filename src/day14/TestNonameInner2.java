package day14;

interface Info1{
	void af();
}
interface Info2{
	void af();
}
class Demo2 implements Info1,Info2{

	Info1 info1 = new Info1() {
		@Override
		public void af() {
			System.out.println("af_info1");
		}
	};
	Info2 info2 = new Info2() { 		
		@Override
		public void af() {
			System.out.println("af_info2");
		}
	};
	
	@Override
	public void af() {
	}
	
}
public class TestNonameInner2 {
	Info1 info1 = new Info1() {
		@Override
		public void af() {
			System.out.println("info1");
		}
	};
	public static void main(String[] args) {
		//匿名内部实现类
		new Info1() {
			public void af() {
				System.out.println("af");
			}
		}.af();

	}

}
