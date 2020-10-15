package day7.BookManageSystem;
/**
 * 
 *图书管理系统2.0(面向对象版)
 */
public class BookManager {
	Book [] books =new Book[100]; //书架
	
	//添加
	public void add(Book book){
		boolean tag = false;
		for (int i = 0;i<books.length;i++)
			if(books[i]==null){
				tag =true;
				books[i]=book;
				//下面这种写法是常见的错误,既然book[i]是null,
				//又怎么可以book[i].no呢?会报空指针异常
//				books[i].no = book.no;
//				books[i].name = book.name;
//				books[i].price = book.price;
				System.out.println("添加成功");
				break;
			}
		if (tag == false){
			System.out.println("书架已满");
		}
	}
	
	//修改
	public void update(int no, String nameNew ,double priceNew){
		boolean tag = false;
		for(int i =0 ; i<books.length ; i++){
			//在"books[i].no==no"前面加上"books[i]!=null&&"的好处是只要books[i]为空了
			//就不会判断&&后面的语句的真假性了,就不会出现空指针异常了,非常巧妙!!!
			if(books[i]!=null&&books[i].no==no){
				tag = true;
				books[i].name = nameNew;
				books[i].price = priceNew;
				System.out.println("修改成功");
			}
		}
		if (tag == false){
			System.out.println("书籍不存在,修改失败");
		}
	}
	
	//删除
	public void delete(int no){
		boolean tag = false;
		for(int i =0 ; i<books.length ; i++){
			//在"books[i].no==no"前面加上"books[i]!=null&&"的好处是只要books[i]为空了
			//就不会判断&&后面的语句的真假性了,就不会出现空指针异常了,非常巧妙!!!
			if(books[i]!=null&&books[i].no==no){
				tag = true;
				books[i]=null;
				System.out.println("删除成功");
			}
		}
		if (tag == false){
			System.out.println("书籍不存在,删除失败");
		}
	}
	//查询所有
	public void queryAll(){
		for(int i = 0 ; i<books.length; i++){
			if(books[i]!=null){
				System.out.println(books[i].show());
			}
		}
	}
	//查询一本书
	public void query(int no){
		boolean tag = false;
		//在"books[i].no==no"前面加上"books[i]!=null&&"的好处是只要books[i]为空了
		//就不会判断&&后面的语句的真假性了,就不会出现空指针异常了,非常巧妙!!!
		for(int i = 0 ; i<books.length; i++){
			if(books[i]!=null&&books[i].no==no){
				tag = true;
				System.out.println(books[i].show());
			}
		}
		if (tag == false){
			System.out.println("书籍不存在,查询失败");
		}
	}
}
