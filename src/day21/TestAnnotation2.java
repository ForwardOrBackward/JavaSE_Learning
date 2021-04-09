package day21;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

//自定义注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface FruitAnno{
	String value() default "这是一个水果";
}

//括号里面加了value="这是一个很好的水果"的话则用当前值"这是一个很好的水果",否则使用默认值"这是一个水果"。
@FruitAnno(value="这是一个很好的水果")
class Fruit{
	private String name;
	public int size;
}

//定义一个枚举类用于下面的注解
enum Color{
	RED,GREEN,YELLO;
}

//再定义一个注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColorAnno{
	Color colorName() default Color.RED;
}


//Apple类继承自Fruit类, 而且自定义注解@FruitAnno是可继承的,所以Apple类也继承了该注解
class Apple extends Fruit{
	//给属性加自定义注解。 由于这里括号里面没有指定参数, 则使用默认值Color.RED
	@ColorAnno()
	private Color color;
}
public class TestAnnotation2 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		/*
		 * 用反射来获得注解的信息
		 */
		//获得 Fruit类型的对象模板
		Class<Fruit> fc = Fruit.class;
		//getDeclaredAnnotations()方法用于获得所有的注解信息
		Annotation [] ans = fc.getDeclaredAnnotations();
		Arrays.stream(ans).forEach(System.out::println);
		/*
		 * 获得子类 继承来的 父类类型上的注解信息
		 */
		//获得Fruit的子类Apple的对象模板
		Class<Apple> ac = Apple.class;
		/*
		 * 获得继承父类上的注解。注意这里一定要用getAnnotations()而不能用getDeclaredAnnotations(),
		 * 因为getDeclaredAnnotations()只能获得当前类的注解,获得不了父类的任何注解,而getAnnotations()
		 * 则可以获得父类的public的注解,而注解都是public的。这就是前面说的getXXX()和getDeclaredXXX()的区别
		 */
		ans = ac.getAnnotations();		
		Arrays.stream(ans).forEach(System.out::println);
		
		//获得Apple类的属性上的注解信息。注意要先get到该属性才行,才能再通过getDeclaredAnnotations()获得注解
		ans = ac.getDeclaredField("color").getDeclaredAnnotations();
		Arrays.stream(ans).forEach(System.out::println);
	
		
	
	}

}
