package day6.BookManageSystem1;

import java.util.Scanner;
/**图书管理系统1.0(面向过程版)*/
public class DemoFromVideo {

	public static void main(String[] args) {
		//容器存数据
		int [] no = new int[100];
		String [] name = new String[100];
		double [] price = new double[100];
		
		System.out.println("\t-图书管理系统-");
		System.out.println(" 1.添加；2.修改；3.删除；4.查询；5.编号查询；6.退出\n\n");
		Scanner superman = new Scanner(System.in);
		int menuNo;
		int bno;
		String bname;
		double bprice;
		while(true) {
			System.out.println("--输入菜单选项：");
			menuNo = superman.nextInt();
			switch(menuNo) {
			case 1://add
				System.out.println("--输入编号：");
				bno = superman.nextInt();
				System.out.println("--输入名称：");
				bname = superman.next();
				System.out.println("--输入价格：");
				bprice = superman.nextDouble();
				//找数组中的第一个空位
				for(int i = 0; i < no.length; i++) {
					if( no[i] == 0) {
						no[i] = bno;
						name[i] = bname;
						price[i] = bprice;
						System.out.println("添加成功");
						break;
					}
				}
				break;
			case 2:
				//update
				System.out.println("--输入要修改的图书的编号：");
				bno = superman.nextInt();
				boolean tag = false;//
				for(int i = 0 ; i< no.length; i++) {
					if(no[i] == bno) {
						tag = true;//找到了
						System.out.println("--输入新的名称：");
						name[i] = superman.next();
						System.out.println("--输入价格：");
						price[i] = superman.nextDouble();
						System.out.println("修改成功");
						break;
					}
				}
				if(tag == false) {
					System.out.println("图书不存在");
				}
				break;
			case 3:
				//delete
				System.out.println("--输入要删除的图书的编号：");
				bno = superman.nextInt();
				for(int i= 0; i < no.length ;i++) {
					if( bno == no[i]) {
						//删除
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
						System.out.println("删除成功");
						break;
					}
				}
				break;
			case 4:
				//select all
				System.out.println("图书编号\t图书名称\t图书价格");
				for(int i= 0; i < no.length; i++) {
					if(no[i] == 0) {
						break;
					}
					System.out.println(no[i] + "\t" + name[i] +"\t" + price[i]);
				}
				break;
			case 5:
				//select by no
				System.out.println("--输入编号：");
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
				//应用程序结束
				System.out.println("退出应用程序");
				System.exit(0);//退出JVM
			}
		}
	
	}
}
