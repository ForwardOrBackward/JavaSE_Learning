package day14;

interface Info{
	public static class InnerDemo{
		int x = 11;
	}
	public static interface Ia{
		int N = 22;
		void af(); //������һ�����󷽷�
		default void df() {} //��������������Ǹ������о����ʵ��,ֻ�����ǿ�ʵ��
		static void sf() {} //��̬����,���ܱ��ӽӿڼ̳�,Ҳ���ܱ���ʵ����ʵ�֡�
	}
}
/*
 * ���������ֱ��ʵ�ֵ���Info���ڲ��ӿ�Ia,������Ҫ��дIa�ĳ��󷽷���
 */
class IaImpl implements Info.Ia{
	@Override
	public void af() {
		System.out.println(N);
		df();//��ʵ�����ڲ��ӿڵ�����,����ֱ�ӵ���Ĭ�Ϸ��������������ʵ�����ⲿ�ӿڵ�����,���޷������ˡ�
		Info.Ia.sf();//��̬����û�б�ʵ����ʵ��,������Ҫֱ���ýӿ���ȥ����
	}	
}
/*
 * ע��,���������ʵ�ֵ����ⲿ�ӿ�,Ҳ����˵�ڲ��ӿڵķ���û�б�ʵ��,�ڲ��ӿڵĳ��󷽷�Ҳ������д
 */
class InfoImpl implements Info{
	public void show() {
		//x��ʵ����Ա,�����ڱ��������Ҫ����������ܷ���
		System.out.println(new InnerDemo().x);
		//�ӿ���(��ʹ���ڲ��ӿ�)�ı���Ĭ����public static final��,���Ա���Nʵ�����Ǹ���̬����
		System.out.println(Ia.N);
		//sf()�����Ǿ�̬����,����ֱ�ӵ��á�����Ҫע������������ʡ��Info�ⲿ�ӿڲ�д��
		Ia.sf();//�ȼ���Info.Ia.sf();
		//���ʵ��Info�ӿڵ������޷�ֱ�ӵ���Ia.df()����,��Ϊ����һ��Ĭ�Ϸ���,�Ǿ�̬��		
		IaImpl ia = new IaImpl();//ֻ��ͨ��Ia�ӿڵ�ʵ���ഴ������������df()
		ia.df();
		
		//---------Ҳ�����������ڲ���ķ�ʽ����df()------------------		
		new Info.Ia() {//��Ҳ��һ��Ia�ӿڵ�ʵ����Ķ���,ֻ����������ʵ����
			@Override
			public void af() {				
			}
		}.df();
		//---------------------------------------------------
	}
}
public class TestStaticInner2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
