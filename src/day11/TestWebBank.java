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
		System.out.println("����ʵ��������֧������");
	}
	public void f() {}
}
interface Child1 extends WebBank{
	
}
public class TestWebBank {

	public static void main(String[] args) {
		//�ӿ� ����        -��    ʵ����
		WebBank jd = new Jingdong();
		jd.webService();
		System.out.println(jd.getClass().getName());
//		jd.f();
	}

}
