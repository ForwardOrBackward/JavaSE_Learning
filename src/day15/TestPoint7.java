package day15;

class Demo4{
	//定义泛型方法
	public <T> void f(T t) {
		System.out.println(t);
	}
	//
	public <T> T func(T t) {
		//这里也会进行类型推断
		f(t);
		f("hello");
		//调用别的泛型方法, 如果要显示指定类型，必须用对象调用。比如说用this,当然创建当前类的对象也可以
		this.<String>f("hello");
		return t;
	}
}
public class TestPoint7 {

	public static void main(String[] args) {
		Demo4 demo = new Demo4();
		//类型推断：参数
		demo.f("hello");
		//显示指定
		demo.<String>f("abc");
		demo.<Integer>f(11);
		System.out.println(demo.func("hello"));
	}

}
