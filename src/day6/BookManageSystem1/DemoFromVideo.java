package day6.BookManageSystem1;

import java.util.Scanner;
/**ͼ�����ϵͳ1.0(������̰�)*/
public class DemoFromVideo {

	public static void main(String[] args) {
		//����������
		int [] no = new int[100];
		String [] name = new String[100];
		double [] price = new double[100];
		
		System.out.println("\t-ͼ�����ϵͳ-");
		System.out.println(" 1.��ӣ�2.�޸ģ�3.ɾ����4.��ѯ��5.��Ų�ѯ��6.�˳�\n\n");
		Scanner superman = new Scanner(System.in);
		int menuNo;
		int bno;
		String bname;
		double bprice;
		while(true) {
			System.out.println("--����˵�ѡ�");
			menuNo = superman.nextInt();
			switch(menuNo) {
			case 1://add
				System.out.println("--�����ţ�");
				bno = superman.nextInt();
				System.out.println("--�������ƣ�");
				bname = superman.next();
				System.out.println("--����۸�");
				bprice = superman.nextDouble();
				//�������еĵ�һ����λ
				for(int i = 0; i < no.length; i++) {
					if( no[i] == 0) {
						no[i] = bno;
						name[i] = bname;
						price[i] = bprice;
						System.out.println("��ӳɹ�");
						break;
					}
				}
				break;
			case 2:
				//update
				System.out.println("--����Ҫ�޸ĵ�ͼ��ı�ţ�");
				bno = superman.nextInt();
				boolean tag = false;//
				for(int i = 0 ; i< no.length; i++) {
					if(no[i] == bno) {
						tag = true;//�ҵ���
						System.out.println("--�����µ����ƣ�");
						name[i] = superman.next();
						System.out.println("--����۸�");
						price[i] = superman.nextDouble();
						System.out.println("�޸ĳɹ�");
						break;
					}
				}
				if(tag == false) {
					System.out.println("ͼ�鲻����");
				}
				break;
			case 3:
				//delete
				System.out.println("--����Ҫɾ����ͼ��ı�ţ�");
				bno = superman.nextInt();
				for(int i= 0; i < no.length ;i++) {
					if( bno == no[i]) {
						//ɾ��
						for(int k = i; k < no.length -1; k++) {
							no[k] = no[k+1];
							name[k] = name[k+1];
							price[k] = price[k+1];
						}
						if(no[no.length-1] != 0) {
							no[no.length-1] = 0;
							name[name.length-1] = null;
							price[price.length-1] = 0.0;
						}
						System.out.println("ɾ���ɹ�");
						break;
					}
				}
				break;
			case 4:
				//select all
				System.out.println("ͼ����\tͼ������\tͼ��۸�");
				for(int i= 0; i < no.length; i++) {
					if(no[i] == 0) {
						break;
					}
					System.out.println(no[i] + "\t" + name[i] +"\t" + price[i]);
				}
				break;
			case 5:
				//select by no
				System.out.println("--�����ţ�");
				bno = superman.nextInt();
				for(int i = 0; i < no.length; i++) {
					if(bno == no[i]) {
						System.out.println(no[i] + "\t" + name[i] + "\t" + price[i]);
						break;
					}
				}
				break;
			case 6:
				//exit
				//Ӧ�ó������
				System.out.println("�˳�Ӧ�ó���");
				System.exit(0);//�˳�JVM
			}
		}
	
	}
}
