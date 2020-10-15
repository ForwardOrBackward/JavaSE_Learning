package day7.BookManageSystem;

public class Book {
	int no;
	String name;
	double price;
	//展示图书信息
	public String show(){
		return no+"\t"+name+"\t"+price;
	}
}
