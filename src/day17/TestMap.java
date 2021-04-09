package day17;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		// 
		Map<Integer,String> map = new HashMap<>();
//		HashMap<Integer,String> map = new HashMap<>();
		//添加元素
		map.put(11, "aa");
		map.put(22, "bb");
		map.put(33, "cc");
		map.put(11, "hello");//键是唯一的，用新的值覆盖旧的值
		map.put(null, null);//HashMap
		System.out.println(map);
		//------------------------------
		//获得 集合中的键值对 的 个数
		System.out.println(map.size());//4
		//返回的是  集合是否为空，空 返回true
		System.out.println(map.isEmpty());//false
		//返回 是否 包含 指定参数 的键
		System.out.println(map.containsKey(22));//true
		//返回是否 包含 指定参数的值
		System.out.println(map.containsValue("cc"));//true
		//删除
		map.remove(22);
		System.out.println(map);//{null=null, 33=cc, 11=hello}
		//修改 值
		map.replace(33, "tom");
		System.out.println(map);//{null=null, 33=tom, 11=hello}
		//
		System.out.println(map.keySet());//[null, 33, 11]
		System.out.println(map.values());//[null, tom, hello]
		//
		map.clear();
		System.out.println(map.isEmpty());//true
	}

}
