package day16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestList2 {

	public static void main(String[] args) {
		// 集合的遍历 
		List<String> list = new ArrayList<>();
		list.add("aa");//0
		list.add("bb");//1
		list.add("cc");//2
		System.out.println(list);//[aa, bb, cc]
		//循环遍历
		//1.普通for List
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//2.增强for
		for(String s:list) {
			System.out.println(s);
		}
		//3.集合的 forEach
		list.forEach(System.out::println);
		//4.Stream 流的 方法forEach
		list.stream().forEach(System.out::println);
		//5. Iterator迭代器  Collection
		//获得了一个 迭代器对象
		System.out.println("-------Iterator--------------");
		Iterator<String>  i = list.iterator();
/*		System.out.println(i.next());
		System.out.println(i.next());// bb
		i.remove();//最近一次 next(）访问的元素
		System.out.println(i.next());
		
		System.out.println(list);//[aa, cc]
*/		//是否存在下一个元素，存在true
		while(i.hasNext()) {
			System.out.println(i.next());
//			list.add("hello");//不允许同时操作
		}
		
		//6.
//		i.forEachRemaining(System.out::println);
//		Iterator<String>  i1 = list.iterator();
//		i1.forEachRemaining(System.out::println);
		//--------------------------------------------
		//7.针对 List集合 的 迭代器  ListIterator
		System.out.println("---------ListIterator--------------");
		ListIterator<String> li = list.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());
			li.add("hello");
		}
		//[aa, hello, bb, hello, cc, hello]
//		System.out.println(list);
		//向上迭代
		System.out.println("-------向上--------");
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}

}
