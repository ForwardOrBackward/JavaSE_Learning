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
		System.out.println("�޲ι�����");
	}
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
		System.out.println("���ι�������" + this.no + "," + this.name);
	}
	public void func() {
		System.out.println("�޲η�����function");
	}
	@Deprecated
	public String show(String str ,int num) {
		return " ���η���" +str +":" + num;
	}
}
public class TestStudent {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		//��� �ֽ����ļ� ��Ӧ�Ķ��еĶ������������ַ����������ַ����õıȽ϶�һЩ
		//1.ͨ��������������,Ȼ��.class����á�
//		Class<Student> c = Student.class;
		//2.ͨ��������ഴ������,Ȼ����getClass()�������
//		Class<? extends Student> c = new Student().getClass();
		//3. ͨ��Class.forName()��������á�forName()������ͨ������һ����ȫ�޶�������������ģ��
		Class<?> c = Class.forName("day21.Student");
		
		//-------------ͨ������ģ��������ֽ����ļ��������------------------------------------
		System.out.println("--------����------------------");
		//getFields()������õ������еĹ�����������ɵ�һ��Field���顣
		Field [] fs = c.getFields();
		//getDeclaredFields()���Ի�����з���Ȩ�����͵�����(����˽������Ҳ���Ի��)
		fs = c.getDeclaredFields();
		for(Field f : fs) {
			//getName()������Ե����� ����:name
			System.out.println(f.getName());
			//getType()������Ե����͡���:int,����:class java.lang.String
			System.out.println(f.getType());
			//getModifiers()��÷���Ȩ��,�������ֵ���ʽ,��public��Ӧ����1,private��Ӧ����2��
			//Modifier.toString()�����ֵķ���Ȩ��ת�������ǳ�������ʽ, ��public
			System.out.println(Modifier.toString(f.getModifiers()));
		}
		//Ҳ����ͨ����������Ϊ����(String����)�����һ�����ԡ������getDeclaredFields()�����ǻ����������
		Field f1 = c.getDeclaredField("name");
		/*
		 * ͨ������ģ��������һ���������(�������Student��)��ʵ�������,ͨ��"����ģ��.newInstance()"��ʵ��
		 */
		Object obj = c.newInstance();
		//ͨ��set()������ʵ��ֱ�Ӹ��Ǿ�̬����(����)��ֵ��
		f1.set(obj, "����");
		System.out.println(f1.get(obj));
		/*
		 * ����������ͨ��set()��������˽������, ��Ϊ��˽�е�, ����ֱ��set()��ֵ�����쳣,
		 * ��Ҫ����һ��˽�����Եķ���Ȩ��Ϊ�ɷ���(�޸ĵķ���Ȩ�޼Ȱ�����Ȩ��(get()����),
		 * Ҳ����дȨ��(set()����),���޸�Ȩ�޵Ļ�, ��д˽�����Զ������쳣��
		 */
		Field f2 = c.getDeclaredField("no");//private
		/*
		 * ���÷���Ȩ��ʱ, ��ʵgetAccessible()����������һ�����:
		 * 	SecurityManager sm = System.getSecurityManager();
		 * ���õ�һ����ȫ�������������������������һ����ȫ������, 
		 * ���������f2.setAccessible(true);���ǰ��һ�����:
		 * 	System.setSecurityManager(new SecurityManager());
		 * ��ʹ�������Ϊtrue, �����˽�б�����Ȩ�޻��ǻ�����ʧ��, �ᱻ��ȫ����������ܾ���
		 */
		f2.setAccessible(true);
		f2.set(obj, 11);
		System.out.println(f2.get(obj));
		
		//-----------------ͨ������ģ��������ֽ����ļ���ķ���--------------------------------
		//
		System.out.println("--------����------------------");
		//getMethods()������õ������е�public�ķ�����ɵ�һ��Method���顣
		//getDeclaredMethods()���Ի�����з���Ȩ�����͵ķ���(����˽������Ҳ���Ի��)
		Method [] ms = c.getDeclaredMethods();
		for(Method m : ms) {
			//getName()��÷��������� ����:show
			System.out.println(m.getName());
			//getReturnType()������÷���ֵ���͡�
			System.out.println(m.getReturnType());
			//getParameterTypes()������в�����������ɵ�һ��Class���� 
			System.out.println(Arrays.toString(m.getParameterTypes()));
		}
		/*
		 * getDeclaredMethod(String name, Class<?>... parameterTypes)ͨ����������:
		 * �����������в�����������ɵ����� ��Ѱ�Ҷ�Ӧ�ķ���,����÷���û�в���,���Բ�ָ��(��Ϊ����һ���ɱ����)
		 * ֮������Ҫ���в��������Ͳ����ҵ���Ӧ�ķ�������Ϊ�ܶ෽�����ж������, ��ָ�����в��������ͻ��Ҵ�
		 */
		Method m1 = c.getDeclaredMethod("func");
		/*
		 * m1.invoke(Object obj, Object... args)��������m1����������objΪ���ø÷����Ķ���,
		 * m1���Ǿ�̬����,������Ҫ������÷�����args�ǵ���m1����ʱ�����÷����Ĳ���, ������޲η���,��
		 * ����args��
		 */
		m1.invoke(obj);
		/*
		 * �����ǵõ���ʹ�������������ķ����ķ�ʽ
		 */
		Method m2 = c.getDeclaredMethod("show", String.class,int.class);
		System.out.println(m2.invoke(obj, "hello",123));
		
		//------------------ͨ������ģ��������ֽ����ļ���Ĺ�����----------------------------------
		System.out.println("------------������----------------------");
		/**
		 * ��ú�ʹ�ù������ķ�ʽ��ǰ������Ժͷ����ķ�ʽ����
		 */
		Constructor<?> [] crs  = c.getDeclaredConstructors();
		for(Constructor<?> cr : crs) {
			System.out.println(Arrays.toString(cr.getParameterTypes()));
		}
		/*
		 * getDeclaredConstructor(Class<?>... parameterTypes)�����������һ��
		 * �������������λ�õľ����޲ι���, �������Ĳ������ͻ�õľ��Ǵ��εĹ�����
		 */
		Constructor<?> cr1 = c.getDeclaredConstructor();
		/*
		 * 
		 * Constructor��newInstance()�����ǵ��õ��������Ĺ�����,ע������Ҳ�Ǵ�������,
		 * ������һ���������Ķ��󡣲���newInstance()���������ǵ����޲ι���,�������Ļ������вι��졣
		 * ע���Class���newInstance()���֡� Class���newInstance()�����ǲ��ܴ��ε�,ֻ�ܵ�
		 * �ò����εĹ�������������
		 */
		cr1.newInstance();//�����޲ι�����,��������һ������
		//���һ�������������Ĺ�����
		Constructor<?> cr2 = c.getDeclaredConstructor(int.class,String.class);
		cr2.newInstance(11,"����");//���ô������Ĺ�����,��������һ������
		
	}

}










