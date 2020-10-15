package day14;

//外部类
class School{
	//静态内部类
	static class WaterFounatin{
		private int n ;
		//静态内部类中可以定义静态变量(就不一定非要是静态常量了)
		private static int sn = 11;
		public WaterFounatin(int n) {
			this.n = n;
		}
		public void show() {
			System.out.println(n);
		}
		//静态内部类中可以定义静态方法
		public static void show1() {
			System.out.println(new WaterFounatin(33).n);//n
			System.out.println(sn);
		}
	}
	
	public void manager() {
		//外部类中 访问  静态内部类中的 实例成员,当然还是要创建对象才能访问
		WaterFounatin w = new WaterFounatin(11);
		w.show();
		//外部类中 访问  静态内部类中的 静态成员,直接访问
		WaterFounatin.show1();
//		w.show1();//当然创建对象来访问静态方法也可以, 但就和以前讲static修饰符的时候说的一样的,不建议这么使用
	}
}
public class TestStaticInner1 {
	public static void main(String[] args) {
		School school = new School();
		school.manager();
		/*
		 * 在其他类中创建静态内部类对象(注意和前面的实例内部类创建对象的区别,那种创建对象的方法会报错)
		 * 因为静态内部类直接属于外部类,所以并不是需要创建外部类对象才能创建内部类的对象。
		 * 
		 * 一个类是静态的并不是表示他不能创建对象,而只是说明他可以不创建对象就被访问(当然这里所说的访问是
		 * 为了访问静态内部类里的方法和变量,只单单访问一个类本身没有任何意义,如果不是为了访问他里面的方法,直
		 * 接"外部类名.内部类名"的话非静态内部类也能做到。"类"说到底就是一种封装,没有实际意义,他里面的变
		 * 量和方法才是我们需要的)
		 * 
		 * 而且定义静态的内部类主要还是为了能在内部类里面创建静态方法和静态变量,
		 * 这是他唯一区别取其他内部类的优势。如果只需要静态常量,那么非静态内部类也可以直接被访问。
		 */
		School.WaterFounatin w = new School.WaterFounatin(55);
		//错误的静态内部类创建对象的方法。
		//School.WaterFounatin w1 = school.new WaterFounatin(55);
		w.show();
		

	}

}
