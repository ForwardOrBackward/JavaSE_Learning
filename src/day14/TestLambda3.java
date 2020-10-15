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
	//4. ���ù����������ù���������Student���󲢸�����������
	La2 la7 = (name)-> {return new Student(name);};
	La2 la8 = Student::new;	
	
	//1.�����෽���� ���ַ���ת������
	La1 la1 = (s) -> {return Integer.parseInt(s);};
	La1 la2 = Integer::parseInt;
	//2.�����ض������ʵ������������"hello"��ĵ�һ��s�Ӵ����ֵ�λ��
	La1 la3 = (s) -> {return "hello".indexOf(s);};
	La1 la4 = "hello"::indexOf;
	//3.����ĳ������ʵ�������������ַ����ĳ���
	La1 la5 = (s) -> {return s.length();};
	La1 la6 = String::length;

	public static void main(String[] args) {
		TestLambda3 t = new TestLambda3();
//		Integer i = t.la1.f("123");
		Integer i = t.la2.f("456");
		System.out.println(i);
	}

}
