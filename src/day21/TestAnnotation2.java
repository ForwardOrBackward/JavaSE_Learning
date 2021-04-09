package day21;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

//�Զ���ע��
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface FruitAnno{
	String value() default "����һ��ˮ��";
}

//�����������value="����һ���ܺõ�ˮ��"�Ļ����õ�ǰֵ"����һ���ܺõ�ˮ��",����ʹ��Ĭ��ֵ"����һ��ˮ��"��
@FruitAnno(value="����һ���ܺõ�ˮ��")
class Fruit{
	private String name;
	public int size;
}

//����һ��ö�������������ע��
enum Color{
	RED,GREEN,YELLO;
}

//�ٶ���һ��ע��
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColorAnno{
	Color colorName() default Color.RED;
}


//Apple��̳���Fruit��, �����Զ���ע��@FruitAnno�ǿɼ̳е�,����Apple��Ҳ�̳��˸�ע��
class Apple extends Fruit{
	//�����Լ��Զ���ע�⡣ ����������������û��ָ������, ��ʹ��Ĭ��ֵColor.RED
	@ColorAnno()
	private Color color;
}
public class TestAnnotation2 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		/*
		 * �÷��������ע�����Ϣ
		 */
		//��� Fruit���͵Ķ���ģ��
		Class<Fruit> fc = Fruit.class;
		//getDeclaredAnnotations()�������ڻ�����е�ע����Ϣ
		Annotation [] ans = fc.getDeclaredAnnotations();
		Arrays.stream(ans).forEach(System.out::println);
		/*
		 * ������� �̳����� ���������ϵ�ע����Ϣ
		 */
		//���Fruit������Apple�Ķ���ģ��
		Class<Apple> ac = Apple.class;
		/*
		 * ��ü̳и����ϵ�ע�⡣ע������һ��Ҫ��getAnnotations()��������getDeclaredAnnotations(),
		 * ��ΪgetDeclaredAnnotations()ֻ�ܻ�õ�ǰ���ע��,��ò��˸�����κ�ע��,��getAnnotations()
		 * ����Ի�ø����public��ע��,��ע�ⶼ��public�ġ������ǰ��˵��getXXX()��getDeclaredXXX()������
		 */
		ans = ac.getAnnotations();		
		Arrays.stream(ans).forEach(System.out::println);
		
		//���Apple��������ϵ�ע����Ϣ��ע��Ҫ��get�������Բ���,������ͨ��getDeclaredAnnotations()���ע��
		ans = ac.getDeclaredField("color").getDeclaredAnnotations();
		Arrays.stream(ans).forEach(System.out::println);
	
		
	
	}

}
