package day14;

//�ⲿ��
class School{
	//��̬�ڲ���
	static class WaterFounatin{
		private int n ;
		//��̬�ڲ����п��Զ��徲̬����(�Ͳ�һ����Ҫ�Ǿ�̬������)
		private static int sn = 11;
		public WaterFounatin(int n) {
			this.n = n;
		}
		public void show() {
			System.out.println(n);
		}
		//��̬�ڲ����п��Զ��徲̬����
		public static void show1() {
			System.out.println(new WaterFounatin(33).n);//n
			System.out.println(sn);
		}
	}
	
	public void manager() {
		//�ⲿ���� ����  ��̬�ڲ����е� ʵ����Ա,��Ȼ����Ҫ����������ܷ���
		WaterFounatin w = new WaterFounatin(11);
		w.show();
		//�ⲿ���� ����  ��̬�ڲ����е� ��̬��Ա,ֱ�ӷ���
		WaterFounatin.show1();
//		w.show1();//��Ȼ�������������ʾ�̬����Ҳ����, ���ͺ���ǰ��static���η���ʱ��˵��һ����,��������ôʹ��
	}
}
public class TestStaticInner1 {
	public static void main(String[] args) {
		School school = new School();
		school.manager();
		/*
		 * ���������д�����̬�ڲ������(ע���ǰ���ʵ���ڲ��ഴ�����������,���ִ�������ķ����ᱨ��)
		 * ��Ϊ��̬�ڲ���ֱ�������ⲿ��,���Բ�������Ҫ�����ⲿ�������ܴ����ڲ���Ķ���
		 * 
		 * һ�����Ǿ�̬�Ĳ����Ǳ�ʾ�����ܴ�������,��ֻ��˵�������Բ���������ͱ�����(��Ȼ������˵�ķ�����
		 * Ϊ�˷��ʾ�̬�ڲ�����ķ����ͱ���,ֻ��������һ���౾��û���κ�����,�������Ϊ�˷���������ķ���,ֱ
		 * ��"�ⲿ����.�ڲ�����"�Ļ��Ǿ�̬�ڲ���Ҳ��������"��"˵���׾���һ�ַ�װ,û��ʵ������,������ı�
		 * ���ͷ�������������Ҫ��)
		 * 
		 * ���Ҷ��徲̬���ڲ�����Ҫ����Ϊ�������ڲ������洴����̬�����;�̬����,
		 * ������Ψһ����ȡ�����ڲ�������ơ����ֻ��Ҫ��̬����,��ô�Ǿ�̬�ڲ���Ҳ����ֱ�ӱ����ʡ�
		 */
		School.WaterFounatin w = new School.WaterFounatin(55);
		//����ľ�̬�ڲ��ഴ������ķ�����
		//School.WaterFounatin w1 = school.new WaterFounatin(55);
		w.show();
		

	}

}
