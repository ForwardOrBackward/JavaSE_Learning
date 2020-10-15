package day13;

public class TestStringBuffer1 {

	public static void main(String[] args) {
		
		//调用无参构造创建对象的话,字符串所对应的字符数组的初始容量 为16个字符
		StringBuffer sf1 = new StringBuffer();
		System.out.println(sf1.capacity());//16
		//使用字符串作为参数创建对象的话,则容量变为16+字符串参数的长度
		StringBuffer sf2 = new StringBuffer("hello");
		System.out.println(sf2.capacity());//21
		//若往sf1末尾追加字符串: 如果追加完后,sf1的长度不超过原容量的大小,则容量不变
		sf1.append("hello");//append可以直接追加到sf1后面,不用写成 sf1 = sf1.append("hello");
		System.out.println(sf1);//hello
		System.out.println(sf1.capacity());//16	
		//若往sf1末尾追加字符串: 如果追加完后,sf1的长度超过原容量的大小,则只能新建一个字符数组储存sf1整个字符序列,原字符数组就舍弃了
		sf1.append("+hellohellohellohello");
		System.out.println(sf1); //hello+hellohellohellohello
		System.out.println(sf1.capacity());//34
		
		StringBuffer sf3 = new StringBuffer(100);
		System.out.println(sf3.capacity());//100
		
		
//		StringBuffer sf = new StringBuffer();
//		System.out.println(sf.capacity());//16
//		sf.append("hello");
//		System.out.println(sf.capacity());//16
		
//		StringBuffer sf = new StringBuffer("hello");
//		sf.trimToSize();
//		System.out.println(sf.capacity());//5
		//------------添加----------------------
		StringBuffer sf = new StringBuffer("hello");
		char [] crs = {'a','b','c'};
		//追加字符数组。在"hello"后面追加字符数组
//		sf.append(crs);//helloabc
		//追加特定范围的字符数组,参数为(待追加的字符数组,起始位置，长度)。在"hello"后面追加字符数组 
		sf.append(crs, 0, 2);//helloab
		System.out.println(sf);
		//插入一个字符串   参数为（插入位置 ，待插入的字符串)。在"helloab"中插入一个字符串
		sf.insert(5, "你好");
		System.out.println(sf);//"hello你好ab"
		//修改当前字符串中的某字符,参数为(要修改的位置，新的字符)。把"hello你好ab"修改
		sf.setCharAt(5, '您');
		System.out.println(sf);//hello您好ab		
		//删除指定位置的字符。参数(待删除的位置)。这里删除"hello您好ab"指定位置的字符
		sf.deleteCharAt(5);
		System.out.println(sf);//hello好ab
		//删除指定范围内的字符序列,参数[起始位置，终止位置）,又是左闭右开的区间。当前字符串为hello好ab"
		sf.delete(5, 8);
		System.out.println(sf);//hello
		//反转当前字符串
		sf.reverse();
		System.out.println(sf);//olleh
		System.out.println(System.currentTimeMillis());
	}

}
