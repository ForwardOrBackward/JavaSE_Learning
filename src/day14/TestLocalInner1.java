package day14;

public class TestLocalInner1 {
	int num = 11;
	static int snum = 22;
	
	public void f() {
		int number = 11;//�ֲ�����
//		number = 22;
		//�ֲ��ڲ���
		class Base{
			public void f() {
				System.out.println(num);
				System.out.println(snum);
				//���Է��ʣ����� �ֲ�������ֵ�������޸�
				System.out.println(number);
			}
		}
	}
	public static void main(String[] args) {
		
		class Base{
			int x = 11;
			static final int n = 55;
			public void f() {
				//ֱ�ӷ��ʾ�̬��Ա
				System.out.println(snum);
				System.out.println(new TestLocalInner1().num);
			}
		}
		class Sub extends Base{
			int y = 22;
		}

		Sub sub = new Sub();
		System.out.println(sub.x);
		System.out.println(sub.y);
	}

}
