package day20;

import java.util.Scanner;

/*class Color{
	//常量
	public static final int RED = 1;
	public static final int GREEN = 2;
	public static final int BLUE = 3;
}*/
/*
 * new 父类名(){
 * 
 * }
 */
interface Info{
	void f();
}
enum Color implements Info{
	RED(11,"红色"){
		@Override
		void af() {
			System.out.println("af _RED");
		}
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}

		
	},GREEN(22,"绿色") {
		@Override
		void af() {
			System.out.println("af_GREEN");
		}
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
	},BLUE(33,"蓝色") {
		@Override
		void af() {
			System.out.println("af_BLUE");
		}
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
	};//枚举类的对象
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
	abstract void af();//定义了一个抽象方法
}
public class TestEnum1 {
	public static void main(String[] args) {
		//定义抽象方法-----------------------------------
		Color.RED.af();
		Color.RED.getClass();
		Color.GREEN.af();
		//可以从写父类方法toString();---------------------------
		/*System.out.println(Color.RED);
		System.out.println(Color.BLUE);*/
		//调用成员方法-----------------------------------------
//		Color.RED.show();
		//可以通过构造器赋值，通过访问器访问--------------------------
	/*	System.out.println(Color.RED.getNo());
		System.out.println(Color.RED.getName());
		System.out.println(Color.BLUE.getNo());
		System.out.println(Color.BLUE.getName());*/
		//通过访问器访问属性值---------------------------------------
/*		Color.RED.setName("红色");
		System.out.println(Color.RED.getName());*/
		//访问成员变量------------------------------------------
//		Color.RED.no = 11;
//		System.out.println(Color.RED.no);
		//switch支持枚举类型的-------------------------------------------
/*		Scanner input = new Scanner(System.in);
		System.out.println("--输入一个颜色：");
		String str = input.next();
		//把字符串 转换成 枚举 Color
		Color color = Color.valueOf(str);
		switch(color) {
		case RED:
			System.out.println("红色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		case BLUE:
			System.out.println("蓝色");
			break;
		}*/
		
		//获得所有的枚举值------------------------------------------------
	/*	for(Color c : Color.values()) {
			System.out.println(c.name());
			System.out.println(c.ordinal());
		}*/
		//获得一个枚举值------------------------------------------------------
//		System.out.println(Color.RED);
		
		

	}

}
