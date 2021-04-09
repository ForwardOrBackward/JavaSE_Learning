package day17;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue2 {

	public static void main(String[] args) {
		// 优先级 排序
		Queue<String> q = new PriorityQueue<>((s1,s2)-> s2.compareTo(s1));
		//入队
		q.add("aa");
		q.add("xx");
		q.add("cc");
		System.out.println(q);//[aa, xx, cc]
		q.add(null);//队列中避免使用null
		System.out.println(q);//[aa, xx, cc]
//		q.forEach(System.out::println);//不能保证顺序
		//出队
		while(q.size() > 0) {
			System.out.println(q.poll());
		}
		
		
	}

}
