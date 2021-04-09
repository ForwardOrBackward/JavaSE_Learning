package day17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

public class TestMap2 {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(11, "aa");
		map.put(22, "bb");
		map.put(33, "cc");
		System.out.println(map);
		// 遍历
		//1.集合 的forEach
		map.forEach(new BiConsumer<Integer, String>() {
			@Override
			public void accept(Integer t, String u) {
				System.out.println(t+ "," + u);
			}			
		});
		map.forEach((t,v)-> System.out.println(t + "," + v));
		//2.键 和 值 分别遍历
		map.keySet().forEach(System.out::println);
		map.values().forEach(System.out::println);
		//3.Iterator  -> Collection
		//分别
		map.keySet().iterator().forEachRemaining(System.out::println);
		map.values().iterator().forEachRemaining(System.out::println);
		//整体键值对
		System.out.println("-----------------------------");
		Iterator<Entry<Integer,String>> i = map.entrySet().iterator();// Entry 键值对 
/*		while(i.hasNext()) {
//			System.out.println(i.next());
			Entry<Integer,String> e = i.next();
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}*/
		map.entrySet().iterator().forEachRemaining(e->System.out.println(e.getKey() + ":" + e.getValue()));
		
//		HashSet<Integer> set = new HashSet<>();
//		set.add(11);
	}

}
