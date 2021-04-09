package day18;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class TestStream {

	public static void main(String[] args) {
		//IntStream
		//创建了一个流  11,33,55
		IntStream is = IntStream.builder().add(11).add(33).add(55).build();
		//最大数
		System.out.println(is.max().getAsInt());//55
		//最小数
//		System.out.println(is.min().getAsInt());
		//总和
//		System.out.println(is.sum());//99
		//平均数
//		System.out.println(is.average().getAsDouble());//33.0
		//流中 的 数据 的个数
//		System.out.println(is.count());//3
		//所有的元素 都 满足条件 才能返回 true
	/*	System.out.println(is.allMatch(new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value > 2;
			}
		}));*/
//		System.out.println(is.allMatch(v -> v > 22));//false
		//流中的元素 只要有 一个满足条件的就是 true
		System.out.println(is.anyMatch(v-> v > 22));//true
	}

}
