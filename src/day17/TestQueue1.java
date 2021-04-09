package day17;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue1 {

	public static void main(String[] args) {
		//队列
		Queue<String> q = new LinkedList<>();
		//入队
		q.add("aa");
		q.add("bb");
		q.add("cc");//添加失败引发异常
		q.offer("dd");//添加失败false
		q.add(null);
//		q.offer(null);
/*		System.out.println(q);//[aa, bb, cc]
		//获得队头元素，不会删除元素
		System.out.println(q.element());//aa
		//失败 ，返回 null
		System.out.println(q.peek());//aa
		q.remove();
		// 删除失败 ，null
		q.poll();
		System.out.println(q);//[ cc, dd]
		
		//出队
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());*/
		//循环 出队
		while(q.size() > 0) {
			System.out.println(q.poll());
		}
	}

}
