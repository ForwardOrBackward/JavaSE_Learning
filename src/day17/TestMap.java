package day17;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		// 
		Map<Integer,String> map = new HashMap<>();
//		HashMap<Integer,String> map = new HashMap<>();
		//���Ԫ��
		map.put(11, "aa");
		map.put(22, "bb");
		map.put(33, "cc");
		map.put(11, "hello");//����Ψһ�ģ����µ�ֵ���Ǿɵ�ֵ
		map.put(null, null);//HashMap
		System.out.println(map);
		//------------------------------
		//��� �����еļ�ֵ�� �� ����
		System.out.println(map.size());//4
		//���ص���  �����Ƿ�Ϊ�գ��� ����true
		System.out.println(map.isEmpty());//false
		//���� �Ƿ� ���� ָ������ �ļ�
		System.out.println(map.containsKey(22));//true
		//�����Ƿ� ���� ָ��������ֵ
		System.out.println(map.containsValue("cc"));//true
		//ɾ��
		map.remove(22);
		System.out.println(map);//{null=null, 33=cc, 11=hello}
		//�޸� ֵ
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
