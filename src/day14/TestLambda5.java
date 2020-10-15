package day14;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;

public class TestLambda5 {

	public static void main(String[] args) {		
		int [] arr = {1,2,3,4,5};
		//3. Stream  :int ,long,double 
		//Êý×é±éÀú
		Arrays.stream(arr).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.print(value);
			}
		});//12345
		Arrays.stream(arr).forEach(e -> System.out.print(e));//12345
		Arrays.stream(arr).forEach(System.out::print);//12345
		
//		System.out.println(Arrays.toString(arr));
		
		
		
	}

}
