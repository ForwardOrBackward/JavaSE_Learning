package day17;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue2 {

	public static void main(String[] args) {
		// ���ȼ� ����
		Queue<String> q = new PriorityQueue<>((s1,s2)-> s2.compareTo(s1));
		//���
		q.add("aa");
		q.add("xx");
		q.add("cc");
		System.out.println(q);//[aa, xx, cc]
		q.add(null);//�����б���ʹ��null
		System.out.println(q);//[aa, xx, cc]
//		q.forEach(System.out::println);//���ܱ�֤˳��
		//����
		while(q.size() > 0) {
			System.out.println(q.poll());
		}
		
		
	}

}
