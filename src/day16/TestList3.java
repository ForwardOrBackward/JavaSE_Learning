package day16;

import java.util.LinkedList;
import java.util.Vector;

public class TestList3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> list = new ArrayList<>(1000);//{}
		Vector<String> list = new Vector<>();
		/*ArrayList:
		 * Ĭ�ϵ������С 10
		 * ���ݣ�1.5������
		 * int newCapacity = oldCapacity + (oldCapacity >> 1);
		 * ��������� Integer.MAX_VALUE
		 * Vector: 2��
		 *   int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
		 */
		list.add("aa");//
		System.out.println(list);
		LinkedList<String> list2 = new LinkedList<>();
		list2.add("aa");
		list2.add("bb");
		list2.addFirst("cc");
		list2.addLast("dd");
		System.out.println(list2);
	}

}
