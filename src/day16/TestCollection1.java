package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestCollection1 {

	public static void main(String[] args) {
		//������һ�����϶���
		Collection<String> c = new ArrayList<>();
		//������,�ɹ� true
		c.add("aa");
		c.add("bb");
		c.add("cc");
		System.out.println(c);//�鿴
		//���� �ǿյ� ��true
		System.out.println(c.isEmpty());//false
		//�Ѿ��洢��Ԫ�صĸ���
		System.out.println(c.size());//3
		//�µļ���
		Collection<String> c1 = new ArrayList<>();
		c1.add("dd");
		c1.add("ee");
		//�Ѳ�������c1�е�����Ԫ�� ��� ����ǰ����c��
		c.addAll(c1);
		System.out.println(c);//[aa, bb, cc, dd, ee]
		//ɾ��ָ��������Ԫ�أ���ǰ���Ϸ����˸ı�true
		c.remove("cc");
		System.out.println(c);//[aa, bb, dd, ee]
		//ɾ�� ���������е� ����Ԫ�أ���ǰ���Ϸ����˸ı�true
		c.removeAll(c1);
		System.out.println(c);//[aa, bb]
		//
		c.add("ccc");
		System.out.println(c);//[aa, bb, ccc]
		//���� ���� ָ��������ɾ�� 
	/*	c.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.length() == 3;
			}
		});*/
		c.removeIf(t->t.length() == 3);
		
		System.out.println(c);//[aa, bb]
		//�ж� ����Ԫ�� �ڼ����� �Ƿ� ���ڣ�������������  true
		System.out.println(c.contains("aa"));
		//[aa, bb]   c1[dd,ee]
		//�������� �е�����Ԫ���� ��ǰ�������Ƿ����������true
		System.out.println(c.containsAll(c1));//false
		//
//		String []str = new String[] {"dd","ee"};
		//��һ������ ת��Ϊ ����------------------------------------------
		//��Arrays�ľ�̬�ڲ��ࣺ ��֧�� ��ӣ�ɾ��
		List<String> list = Arrays.asList(new String[] {"dd","ee"});
		c.addAll(list);
		System.out.println(c);//[aa, bb, dd, ee]
		System.out.println(c.containsAll(c1));//trues
		//----------------------------------------------------------
		//���� ת�� ������
//		Object [] obj = c.toArray();
//		Object [] obj = c.toArray(new Object[0]);
//		Object [] obj = c.toArray(new Object[4]);	
//		String [] str = c.toArray(new String[0]);
		String [] str = c.toArray(new String[4]);
		Arrays.stream(str).forEach(System.out::println);
		//��������е�����Ԫ��
		c.clear();
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
	}

}
