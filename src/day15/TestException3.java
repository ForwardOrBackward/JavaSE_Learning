package day15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException3 {

	public void a() {
		Scanner input = new Scanner(System.in);
		int n1,n2,n3;
		System.out.println("输入两个数：");
		try {
			n1 = input.nextInt();//InputMismatchException 对象
			n2 = input.nextInt();
			n3 = n1 / n2;//ArithmeticException对象
			System.out.println("结果：" + n3);
//			return;
//			System.exit(0);
		}catch(ArithmeticException e) {
//			System.out.println("异常了");
//			System.out.println(e);
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(InputMismatchException e) {
//			System.out.println("异常了");
			System.out.println(e);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("资源释放……………………………………");
		}
		
	}
	public static void main(String[] args) {
		new TestException3().a();
		

	}

}
