package day20;

import java.util.Scanner;

/*class Color{
	//����
	public static final int RED = 1;
	public static final int GREEN = 2;
	public static final int BLUE = 3;
}*/
/*
 * new ������(){
 * 
 * }
 */
interface Info{
	void f();
}
enum Color implements Info{
	RED(11,"��ɫ"){
		@Override
		void af() {
			System.out.println("af _RED");
		}
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}

		
	},GREEN(22,"��ɫ") {
		@Override
		void af() {
			System.out.println("af_GREEN");
		}
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
	},BLUE(33,"��ɫ") {
		@Override
		void af() {
			System.out.println("af_BLUE");
		}
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
	};//ö����Ķ���
	private int no;
	private String name;
	private Color(int no, String name) {//private 
		this.no = no;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.no + "," + this.name();
	}
	@Override
	public void f() {
		System.out.println();
	}
	abstract void af();//������һ�����󷽷�
}
public class TestEnum1 {
	public static void main(String[] args) {
		//������󷽷�-----------------------------------
		Color.RED.af();
		Color.RED.getClass();
		Color.GREEN.af();
		//���Դ�д���෽��toString();---------------------------
		/*System.out.println(Color.RED);
		System.out.println(Color.BLUE);*/
		//���ó�Ա����-----------------------------------------
//		Color.RED.show();
		//����ͨ����������ֵ��ͨ������������--------------------------
	/*	System.out.println(Color.RED.getNo());
		System.out.println(Color.RED.getName());
		System.out.println(Color.BLUE.getNo());
		System.out.println(Color.BLUE.getName());*/
		//ͨ����������������ֵ---------------------------------------
/*		Color.RED.setName("��ɫ");
		System.out.println(Color.RED.getName());*/
		//���ʳ�Ա����------------------------------------------
//		Color.RED.no = 11;
//		System.out.println(Color.RED.no);
		//switch֧��ö�����͵�-------------------------------------------
/*		Scanner input = new Scanner(System.in);
		System.out.println("--����һ����ɫ��");
		String str = input.next();
		//���ַ��� ת���� ö�� Color
		Color color = Color.valueOf(str);
		switch(color) {
		case RED:
			System.out.println("��ɫ");
			break;
		case GREEN:
			System.out.println("��ɫ");
			break;
		case BLUE:
			System.out.println("��ɫ");
			break;
		}*/
		
		//������е�ö��ֵ------------------------------------------------
	/*	for(Color c : Color.values()) {
			System.out.println(c.name());
			System.out.println(c.ordinal());
		}*/
		//���һ��ö��ֵ------------------------------------------------------
//		System.out.println(Color.RED);
		
		

	}

}
