package day7.BookManageSystem;

import java.util.Scanner;

/**ͼ����*/
public class Test {
	//����һ���˵�
	public void menu(){
		System.out.println("\t-ͼ�����ϵͳ-");
		System.out.println(" 1.��ӣ�2.�޸ģ�3.ɾ����4.��ѯ��5.��Ų�ѯ��6.�˳�\n\n");
	}
	//չʾ�ò˵�����ʾ�û�������Ӧ�Ĺؼ���
	public void startMenu(){
		//չʾ�˵�
		menu();
		int menuNo;
		int bno;
		String bname;
		double bprice;
		BookManager manager = new BookManager();
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("--������˵����:");
			menuNo = input.nextInt();
			switch (menuNo){
			case 1:
				//add
				//һ��Ҫ�ǵ�ÿ����һ������һ��Ҫnewһ���µ�,���·����ַ�ռ�
				//��Ȼ��������е��鶼��ָ��ͬһ����ĵ�ַ
				Book book = new Book();
				System.out.println("����������ͼ��ı��");
				book.no=input.nextInt();
				System.out.println("����������ͼ�������");
				book.name = input.next();
				System.out.println("����������ͼ��ļ۸�");
				book.price = input.nextDouble();
				manager.add(book);
				break;
			case 2:
				//update
				System.out.println("������Ҫ�޸ĵ�ͼ��ı��");
				bno = input.nextInt();
				System.out.println("�������µ�ͼ�������");
				bname = input.next();
				System.out.println("�������µ�ͼ��ļ۸�");
				bprice = input.nextDouble();
				//�޸ĵĺ����������̫��,���Դ���(Book book),��Ϊ�˱���������������
				//�Ȿ��Ҫ��ѭ������new��,����manager.update�������︳ֵ��Ҫ�޸ĵ���Ҳ��
				//һ������һ�����Եĸ�,������manager.addһ��ֱ��books[i]=book;(add����Ҳ
				//ֻ��������ֵ,�����ڸ�����һ��һ����ֵ,��Ϊbooks[i]����null,��û����ռ�)�����޸�
				//��������鶼��ָ��ͬһ����ĵ�ַ
				manager.update(bno, bname, bprice);
				break;
			case 3:
				//delete
				System.out.println("������Ҫɾ����ͼ��ı��");
				bno = input.nextInt();
				manager.delete(bno);
				break;
			case 4:
				//queryAll
				System.out.println("ͼ����\tͼ������\tͼ��۸�");
				manager.queryAll();
				break;
			case 5:
				//query
				System.out.println("������Ҫ���ҵ�ͼ��ı��");
				bno = input.nextInt();
				System.out.println("ͼ����\tͼ������\tͼ��۸�");
				manager.query(bno);
				break;
			case 6:
				//exit
				System.out.println("�˳�����");
				System.exit(0);
				break;
			default :
				System.out.println("������Ч!����������:");
			}
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.startMenu();
	}
	
}
