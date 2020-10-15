package day16;

import java.util.Vector;

public class TestList3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> list = new ArrayList<>(1000);//{}
		Vector<String> list = new Vector<>();
		/*ArrayList:
		 * 默认的数组大小 10
		 * 扩容：1.5倍扩容
		 * int newCapacity = oldCapacity + (oldCapacity >> 1);
		 * 最大容量： Integer.MAX_VALUE
		 * Vector: 2倍
		 *   int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
		 */
		list.add("aa");//
		System.out.println(list);
	}

}
