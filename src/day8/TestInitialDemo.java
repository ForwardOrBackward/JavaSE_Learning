package day8;
//成员变量初始化 的过程
class Demo{
	
	Demo(){
		n = 33;
	}
	{
		n = 22;
	}
	private int n = 11;	
	public int show() {
		return n;
	}
}
public class TestInitialDemo {

	public static void main(String[] args) {
		Demo demo = new Demo();
		System.out.println(demo.show());

	}

}
