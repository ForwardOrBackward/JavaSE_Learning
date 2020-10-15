package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections1 {

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(33);
		System.out.println(list);
		//向集合中 添加多个元素
		Collections.addAll(list, 56,77,88,22);
		System.out.println(list);//[12, 33, 56, 77, 88, 22]
		//升序排序
		Collections.sort(list);
		System.out.println(list);//[12, 22, 33, 56, 77, 88]
//		Collections.sort(list, (n1,n2)->n2 - n1);
		System.out.println(list);//[88, 77, 56, 33, 22, 12]
		//前提升序排序
		System.out.println(Collections.binarySearch(list, 22));//1
		//最大值和最小值
		System.out.println(Collections.max(list));//8
		System.out.println(Collections.min(list));//12
		//反转集合元素
		Collections.reverse(list);
		System.out.println(list);//[88, 77, 56, 33, 22, 12]
		//
		list.add(12);
		System.out.println(list);
		//获得 第二个参数元素  在 集合中 出现的频率（次数）
		System.out.println(Collections.frequency(list, 12));//2
		//对集合元素 重新排列 （洗牌）
		Collections.shuffle(list);
		System.out.println(list);
		//用第二个参数元素 替换掉 集合中的所有元素 。填充
		Collections.fill(list, 666);
		System.out.println(list);
		
		
		
	}

}
