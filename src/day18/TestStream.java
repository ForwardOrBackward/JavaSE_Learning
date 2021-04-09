package day18;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class TestStream {

	public static void main(String[] args) {
		//IntStream
		//������һ����  11,33,55
		IntStream is = IntStream.builder().add(11).add(33).add(55).build();
		//�����
		System.out.println(is.max().getAsInt());//55
		//��С��
//		System.out.println(is.min().getAsInt());
		//�ܺ�
//		System.out.println(is.sum());//99
		//ƽ����
//		System.out.println(is.average().getAsDouble());//33.0
		//���� �� ���� �ĸ���
//		System.out.println(is.count());//3
		//���е�Ԫ�� �� �������� ���ܷ��� true
	/*	System.out.println(is.allMatch(new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value > 2;
			}
		}));*/
//		System.out.println(is.allMatch(v -> v > 22));//false
		//���е�Ԫ�� ֻҪ�� һ�����������ľ��� true
		System.out.println(is.anyMatch(v-> v > 22));//true
	}

}
