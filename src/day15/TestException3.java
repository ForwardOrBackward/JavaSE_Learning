package day15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException3 {

	public void a() {
		Scanner input = new Scanner(System.in);
		int n1,n2,n3;
		System.out.println("������������");
		try {
			n1 = input.nextInt();//InputMismatchException ����
			n2 = input.nextInt();
			n3 = n1 / n2;//ArithmeticException����
			System.out.println("�����" + n3);
//			return;
//			System.exit(0);
		}catch(ArithmeticException e) {
//			System.out.println("�쳣��");
//			System.out.println(e);
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(InputMismatchException e) {
//			System.out.println("�쳣��");
			System.out.println(e);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("��Դ�ͷš���������������������������");
		}
		
	}
	public static void main(String[] args) {
		new TestException3().a();
		

	}

}
