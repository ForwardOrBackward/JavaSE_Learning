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
		//�򼯺��� ��Ӷ��Ԫ��
		Collections.addAll(list, 56,77,88,22);
		System.out.println(list);//[12, 33, 56, 77, 88, 22]
		//��������
		Collections.sort(list);
		System.out.println(list);//[12, 22, 33, 56, 77, 88]
//		Collections.sort(list, (n1,n2)->n2 - n1);
		System.out.println(list);//[88, 77, 56, 33, 22, 12]
		//ǰ����������
		System.out.println(Collections.binarySearch(list, 22));//1
		//���ֵ����Сֵ
		System.out.println(Collections.max(list));//8
		System.out.println(Collections.min(list));//12
		//��ת����Ԫ��
		Collections.reverse(list);
		System.out.println(list);//[88, 77, 56, 33, 22, 12]
		//
		list.add(12);
		System.out.println(list);
		//��� �ڶ�������Ԫ��  �� ������ ���ֵ�Ƶ�ʣ�������
		System.out.println(Collections.frequency(list, 12));//2
		//�Լ���Ԫ�� �������� ��ϴ�ƣ�
		Collections.shuffle(list);
		System.out.println(list);
		//�õڶ�������Ԫ�� �滻�� �����е�����Ԫ�� �����
		Collections.fill(list, 666);
		System.out.println(list);
		
		
		
	}

}
