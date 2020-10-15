package day14;

interface La1{
	Integer f(String s);
}
class Student{
	private String name;
	Student(String name){
		this.name = name;
	}
}
interface La2{
	Student f(String name);
}
public class TestLambda3 {	
	//4. 引用构造器。调用构造器创建Student对象并给构造器传参
	La2 la7 = (name)-> {return new Student(name);};
	La2 la8 = Student::new;	
	
	//1.引用类方法。 将字符串转成整型
	La1 la1 = (s) -> {return Integer.parseInt(s);};
	La1 la2 = Integer::parseInt;
	//2.引用特定对象的实例方法。返回"hello"里的第一次s子串出现的位置
	La1 la3 = (s) -> {return "hello".indexOf(s);};
	La1 la4 = "hello"::indexOf;
	//3.引用某类对象的实例方法。返回字符串的长度
	La1 la5 = (s) -> {return s.length();};
	La1 la6 = String::length;

	public static void main(String[] args) {
		TestLambda3 t = new TestLambda3();
//		Integer i = t.la1.f("123");
		Integer i = t.la2.f("456");
		System.out.println(i);
	}

}
