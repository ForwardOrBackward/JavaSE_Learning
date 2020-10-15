package day17;

import java.util.SortedSet;
import java.util.TreeSet;

public class TestSet2 {

	public static void main(String[] args) {
		//SortedSet
		SortedSet<Integer> set = new TreeSet<>((n1,n2)-> n2 - n1);
		set.add(22);
		set.add(11);
		set.add(33);
		System.out.println(set);//[33, 22, 11]
/*		//
		System.out.println(set.first());//11
		System.out.println(set.last());//33
		//
		System.out.println("----------------------");
		set.subSet(11, 33).forEach(System.out::println);
		//               [起始的元素，终止的元素）  不包括终止元素
		set = set.subSet(11, 33);
		System.out.println(set);//[11, 22]
*/		
	}

}
