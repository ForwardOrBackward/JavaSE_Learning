package day17;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue1 {

	public static void main(String[] args) {
		//����
		Queue<String> q = new LinkedList<>();
		//���
		q.add("aa");
		q.add("bb");
		q.add("cc");//���ʧ�������쳣
		q.offer("dd");//���ʧ��false
		q.add(null);
//		q.offer(null);
/*		System.out.println(q);//[aa, bb, cc]
		//��ö�ͷԪ�أ�����ɾ��Ԫ��
		System.out.println(q.element());//aa
		//ʧ�� ������ null
		System.out.println(q.peek());//aa
		q.remove();
		// ɾ��ʧ�� ��null
		q.poll();
		System.out.println(q);//[ cc, dd]
		
		//����
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());*/
		//ѭ�� ����
		while(q.size() > 0) {
			System.out.println(q.poll());
		}
	}

}
