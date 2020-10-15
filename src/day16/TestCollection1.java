package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestCollection1 {

	public static void main(String[] args) {
		//创建了一个集合对象
		Collection<String> c = new ArrayList<>();
		//存数据,成功 true
		c.add("aa");
		c.add("bb");
		c.add("cc");
		System.out.println(c);//查看
		//集合 是空的 ，true
		System.out.println(c.isEmpty());//false
		//已经存储的元素的个数
		System.out.println(c.size());//3
		//新的集合
		Collection<String> c1 = new ArrayList<>();
		c1.add("dd");
		c1.add("ee");
		//把参数集合c1中的所有元素 添加 到当前集合c中
		c.addAll(c1);
		System.out.println(c);//[aa, bb, cc, dd, ee]
		//删除指定参数的元素，当前集合发生了改变true
		c.remove("cc");
		System.out.println(c);//[aa, bb, dd, ee]
		//删除 参数集合中的 所有元素，当前集合发生了改变true
		c.removeAll(c1);
		System.out.println(c);//[aa, bb]
		//
		c.add("ccc");
		System.out.println(c);//[aa, bb, ccc]
		//按照 参数 指定的条件删除 
	/*	c.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.length() == 3;
			}
		});*/
		c.removeIf(t->t.length() == 3);
		
		System.out.println(c);//[aa, bb]
		//判断 参数元素 在集合中 是否 存在（包含），存在  true
		System.out.println(c.contains("aa"));
		//[aa, bb]   c1[dd,ee]
		//参数集合 中的所有元素在 当前集合中是否包含，包含true
		System.out.println(c.containsAll(c1));//false
		//
//		String []str = new String[] {"dd","ee"};
		//把一个数组 转换为 集合------------------------------------------
		//是Arrays的静态内部类： 不支持 添加，删除
		List<String> list = Arrays.asList(new String[] {"dd","ee"});
		c.addAll(list);
		System.out.println(c);//[aa, bb, dd, ee]
		System.out.println(c.containsAll(c1));//trues
		//----------------------------------------------------------
		//集合 转换 成数组
//		Object [] obj = c.toArray();
//		Object [] obj = c.toArray(new Object[0]);
//		Object [] obj = c.toArray(new Object[4]);	
//		String [] str = c.toArray(new String[0]);
		String [] str = c.toArray(new String[4]);
		Arrays.stream(str).forEach(System.out::println);
		//清除集合中的所有元素
		c.clear();
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
	}

}
