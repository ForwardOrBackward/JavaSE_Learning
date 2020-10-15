package day7.BookManageSystem;

import java.util.Scanner;

/**图书类*/
public class Test {
	//定义一个菜单
	public void menu(){
		System.out.println("\t-图书管理系统-");
		System.out.println(" 1.添加；2.修改；3.删除；4.查询；5.编号查询；6.退出\n\n");
	}
	//展示该菜单并提示用户输入相应的关键字
	public void startMenu(){
		//展示菜单
		menu();
		int menuNo;
		int bno;
		String bname;
		double bprice;
		BookManager manager = new BookManager();
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("--请输入菜单编号:");
			menuNo = input.nextInt();
			switch (menuNo){
			case 1:
				//add
				//一定要记得每产生一本新书一定要new一本新的,重新分配地址空间
				//不然书架上所有的书都会指向同一本书的地址
				Book book = new Book();
				System.out.println("请输入新增图书的编号");
				book.no=input.nextInt();
				System.out.println("请输入新增图书的名字");
				book.name = input.next();
				System.out.println("请输入新增图书的价格");
				book.price = input.nextDouble();
				manager.add(book);
				break;
			case 2:
				//update
				System.out.println("请输入要修改的图书的编号");
				bno = input.nextInt();
				System.out.println("请输入新的图书的名字");
				bname = input.next();
				System.out.println("请输入新的图书的价格");
				bprice = input.nextDouble();
				//修改的函数如果参数太多,可以传参(Book book),但为了避免产生过多的垃圾
				//这本书要在循环外面new好,而且manager.update方法体里赋值给要修改的书也是
				//一个属性一个属性的赋,不能像manager.add一样直接books[i]=book;(add方法也
				//只能这样赋值,不存在给属性一个一个赋值,因为books[i]都是null,还没分配空间)否则修改
				//后的所有书都会指向同一本书的地址
				manager.update(bno, bname, bprice);
				break;
			case 3:
				//delete
				System.out.println("请输入要删除的图书的编号");
				bno = input.nextInt();
				manager.delete(bno);
				break;
			case 4:
				//queryAll
				System.out.println("图书编号\t图书名称\t图书价格");
				manager.queryAll();
				break;
			case 5:
				//query
				System.out.println("请输入要查找的图书的编号");
				bno = input.nextInt();
				System.out.println("图书编号\t图书名称\t图书价格");
				manager.query(bno);
				break;
			case 6:
				//exit
				System.out.println("退出程序");
				System.exit(0);
				break;
			default :
				System.out.println("输入无效!请重新输入:");
			}
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.startMenu();
	}
	
}
