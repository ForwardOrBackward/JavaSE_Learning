package day14;

class Base{
	class Inner{}
}
class Sub extends Base{
	/*
	 * ����̳и���ʱ,ֻ��ʵ�����������д�Ļ� �Ḳ�Ǹ���ķ���,�����ĳ�Ա�����ͬ��
	 * �Ķ����Ḳ�Ǹ���ĳ�Ա��
	 * ���ڲ����ڼ̳к��������ͬ���ڲ���,Ҳ���Ḳ�Ǹ����е� �ڲ��ࡣ��Ϊ����������
	 * �ڲ�����ֽ����ļ����ļ���ʵ�����ǲ�һ���ġ������ڲ���Inner���ֽ����ļ���
	 * Ϊ:Base$Inner.class, �������ڲ���Inner���ֽ����ļ���Ϊ:Sub$Inner.class
	 */
	
	class Inner{}
}
public class TestStaticInner4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
