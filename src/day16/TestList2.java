package day16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestList2 {

	public static void main(String[] args) {
		// ���ϵı��� 
		List<String> list = new ArrayList<>();
		list.add("aa");//0
		list.add("bb");//1
		list.add("cc");//2
		System.out.println(list);//[aa, bb, cc]
		//ѭ������
		//1.��ͨfor List
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//2.��ǿfor
		for(String s:list) {
			System.out.println(s);
		}
		//3.���ϵ� forEach
		list.forEach(System.out::println);
		//4.Stream ���� ����forEach
		list.stream().forEach(System.out::println);
		//5. Iterator������  Collection
		//�����һ�� ����������
		System.out.println("-------Iterator--------------");
		Iterator<String>  i = list.iterator();
/*		System.out.println(i.next());
		System.out.println(i.next());// bb
		i.remove();//���һ�� next(�����ʵ�Ԫ��
		System.out.println(i.next());
		
		System.out.println(list);//[aa, cc]
*/		//�Ƿ������һ��Ԫ�أ�����true
		while(i.hasNext()) {
			System.out.println(i.next());
//			list.add("hello");//������ͬʱ����
		}
		
		//6.
//		i.forEachRemaining(System.out::println);
//		Iterator<String>  i1 = list.iterator();
//		i1.forEachRemaining(System.out::println);
		//--------------------------------------------
		//7.��� List���� �� ������  ListIterator
		System.out.println("---------ListIterator--------------");
		ListIterator<String> li = list.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());
			li.add("hello");
		}
		//[aa, hello, bb, hello, cc, hello]
//		System.out.println(list);
		//���ϵ���
		System.out.println("-------����--------");
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}

}
