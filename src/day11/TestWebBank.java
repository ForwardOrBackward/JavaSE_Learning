package day11;

interface WebBank{
	void webService();
//	public abstract void webService();
}
interface WebBank2{
	public static final int s =10;
//	public abstract void webService();
}
 class Jingdong implements WebBank ,WebBank2{
	@Override
	public void webService() {
		System.out.println("京东实现了网上支付功能");
	}
	public void f() {}
}
interface Child1 extends WebBank{
	
}
public class TestWebBank {

	public static void main(String[] args) {
		//接口 引用        -》    实现类
		WebBank jd = new Jingdong();
		jd.webService();
		System.out.println(jd.getClass().getName());
//		jd.f();
	}

}
