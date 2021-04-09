package day21;

public class testReflect {
	public static void main(String[] args) throws ClassNotFoundException {
		//String   当前的class类用于描述String这个类的特征的（属性   方法   构造方法）
		String str="test";
		Class class01=String.class;
		Class class02 = str.getClass();
		Class class03 = Class.forName("java.lang.String");
		System.out.println(class01==class02);//true
		System.out.println(class02==class03);//true
		boolean ss=(int.class==Integer.class);
		System.out.println(ss);//false
		System.out.println(int.class);//int
		System.out.println(void.class);//void
		System.out.println(void.class.isPrimitive());//true
		System.out.println(String.class.isPrimitive());//false
		System.out.println(int[].class.isPrimitive());//false
		System.out.println(int[].class.isArray());//true
		
		//Integer.TYPE  返回integer的包装的预定义类型。所以和int.class相等
		boolean ss01=(int.class==Integer.TYPE);
		System.out.println(ss01);//true
	}

}
