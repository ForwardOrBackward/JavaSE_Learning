package day15;

class Demo4{
	//���巺�ͷ���
	public <T> void f(T t) {
		System.out.println(t);
	}
	//
	public <T> T func(T t) {
		//����Ҳ����������ƶ�
		f(t);
		f("hello");
		//���ñ�ķ��ͷ���, ���Ҫ��ʾָ�����ͣ������ö�����á�����˵��this,��Ȼ������ǰ��Ķ���Ҳ����
		this.<String>f("hello");
		return t;
	}
}
public class TestPoint7 {

	public static void main(String[] args) {
		Demo4 demo = new Demo4();
		//�����ƶϣ�����
		demo.f("hello");
		//��ʾָ��
		demo.<String>f("abc");
		demo.<Integer>f(11);
		System.out.println(demo.func("hello"));
	}

}
