package day21;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
@Deprecated
class Student{
	private int no;
	public String name;
	public Student() {
		System.out.println("无参构造器");
	}
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
		System.out.println("带参构造器：" + this.no + "," + this.name);
	}
	public void func() {
		System.out.println("无参方法：function");
	}
	@Deprecated
	public String show(String str ,int num) {
		return " 带参方法" +str +":" + num;
	}
}
public class TestStudent {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		//获得 字节码文件 对应的堆中的对象。有下面三种方法。第三种方法用的比较多一些
		//1.通过具体的类的类名,然后.class来获得。
//		Class<Student> c = Student.class;
		//2.通过具体的类创建对象,然后用getClass()方法获得
//		Class<? extends Student> c = new Student().getClass();
		//3. 通过Class.forName()方法来获得。forName()方法是通过传入一个完全限定名来获得其对象模板
		Class<?> c = Class.forName("day21.Student");
		
		//-------------通过对象模板来获得字节码文件里的属性------------------------------------
		System.out.println("--------属性------------------");
		//getFields()方法获得的是所有的公共的属性组成的一个Field数组。
		Field [] fs = c.getFields();
		//getDeclaredFields()可以获得所有访问权限类型的属性(包括私有属性也可以获得)
		fs = c.getDeclaredFields();
		for(Field f : fs) {
			//getName()获得属性的名字 。如:name
			System.out.println(f.getName());
			//getType()获得属性的类型。如:int,又如:class java.lang.String
			System.out.println(f.getType());
			//getModifiers()获得访问权限,但是数字的形式,如public对应的是1,private对应的是2。
			//Modifier.toString()将数字的访问权限转换成我们常见的形式, 如public
			System.out.println(Modifier.toString(f.getModifiers()));
		}
		//也可以通过属性名作为参数(String类型)来获得一个属性。上面的getDeclaredFields()方法是获得所有属性
		Field f1 = c.getDeclaredField("name");
		/*
		 * 通过对象模板来创建一个具体的类(如这里的Student类)的实例或对象,通过"对象模板.newInstance()"来实现
		 */
		Object obj = c.newInstance();
		//通过set()方法来实现直接给非静态属性(变量)赋值。
		f1.set(obj, "张三");
		System.out.println(f1.get(obj));
		/*
		 * 接下来尝试通过set()方法访问私有属性, 因为是私有的, 所以直接set()赋值会抛异常,
		 * 需要设置一下私有属性的访问权限为可访问(修改的访问权限既包括读权限(get()方法),
		 * 也包括写权限(set()方法),不修改权限的话, 读写私有属性都会抛异常。
		 */
		Field f2 = c.getDeclaredField("no");//private
		/*
		 * 设置访问权限时, 其实getAccessible()方法里面有一条语句:
		 * 	SecurityManager sm = System.getSecurityManager();
		 * 来得到一个安全管理器。所以如果我们设置了一个安全管理器, 
		 * 如在下面的f2.setAccessible(true);语句前加一条语句:
		 * 	System.setSecurityManager(new SecurityManager());
		 * 则即使传入参数为true, 想访问私有变量的权限还是会设置失败, 会被安全管理器检查后拒绝。
		 */
		f2.setAccessible(true);
		f2.set(obj, 11);
		System.out.println(f2.get(obj));
		
		//-----------------通过对象模板来获得字节码文件里的方法--------------------------------
		//
		System.out.println("--------方法------------------");
		//getMethods()方法获得的是所有的public的方法组成的一个Method数组。
		//getDeclaredMethods()可以获得所有访问权限类型的方法(包括私有属性也可以获得)
		Method [] ms = c.getDeclaredMethods();
		for(Method m : ms) {
			//getName()获得方法的名字 。如:show
			System.out.println(m.getName());
			//getReturnType()方法获得返回值类型。
			System.out.println(m.getReturnType());
			//getParameterTypes()获得所有参数的类型组成的一个Class数组 
			System.out.println(Arrays.toString(m.getParameterTypes()));
		}
		/*
		 * getDeclaredMethod(String name, Class<?>... parameterTypes)通过两个参数:
		 * 方法名、所有参数的类型组成的数组 来寻找对应的方法,如果该方法没有参数,可以不指定(因为这是一个可变参数)
		 * 之所以需要所有参数的类型才能找到对应的方法是因为很多方法都有多个重载, 不指定所有参数的类型会找错。
		 */
		Method m1 = c.getDeclaredMethod("func");
		/*
		 * m1.invoke(Object obj, Object... args)用来调用m1方法。其中obj为调用该方法的对象,
		 * m1不是静态方法,所以需要对象调用方法。args是调用m1方法时传给该方法的参数, 如果是无参方法,则
		 * 不用args。
		 */
		m1.invoke(obj);
		/*
		 * 下面是得到并使用有两个参数的方法的方式
		 */
		Method m2 = c.getDeclaredMethod("show", String.class,int.class);
		System.out.println(m2.invoke(obj, "hello",123));
		
		//------------------通过对象模板来获得字节码文件里的构造器----------------------------------
		System.out.println("------------构造器----------------------");
		/**
		 * 获得和使用构造器的方式和前面的属性和方法的方式类似
		 */
		Constructor<?> [] crs  = c.getDeclaredConstructors();
		for(Constructor<?> cr : crs) {
			System.out.println(Arrays.toString(cr.getParameterTypes()));
		}
		/*
		 * getDeclaredConstructor(Class<?>... parameterTypes)方法用来获得一个
		 * 构造器。不传参获得的就是无参构造, 传入具体的参数类型获得的就是带参的构造器
		 */
		Constructor<?> cr1 = c.getDeclaredConstructor();
		/*
		 * 
		 * Constructor的newInstance()方法是调用到具体的类的构造器,注意这里也是创建对象,
		 * 创建了一个具体的类的对象。不给newInstance()传参数就是调用无参构造,传参数的话就是有参构造。
		 * 注意和Class类的newInstance()区分。 Class类的newInstance()方法是不能传参的,只能调
		 * 用不带参的构造器创建对象
		 */
		cr1.newInstance();//调用无参构造器,并创建了一个对象。
		//获得一个带两个参数的构造器
		Constructor<?> cr2 = c.getDeclaredConstructor(int.class,String.class);
		cr2.newInstance(11,"李四");//调用带参数的构造器,并创建了一个对象
		
	}

}










