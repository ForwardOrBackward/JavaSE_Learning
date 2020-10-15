package day8;
class Role{
	private String name;
	private int age;
	private String sex;
	//声明处初始化
	private String address = "内蒙古";
	private String job;

	public  Role() {
		this.name = "匿名";
//		this.address = "内蒙古";
	}
	public Role(String job) {
		this();//无参
		this.job = job;
	}
	public Role(String name,String sex,String job) {
//		this.name = name;
//		this.sex = sex;
//		this.job = job;
		//this(name,sex,0,null,job);
	}
	public Role(String name,String sex,int age,String address,String job) {
//		this(name,sex,job);
		this.age = age;
		this.address = address;
		
		this.name = name;//
		this.sex = sex;//
		this.job = job;//
//		this.address = "内蒙古";
//		this("郭靖","男","侠客");
	}
	//代码块:构造块
	{
		this.address = "内蒙古";
	}
	public String show() {
		return this.name +"\t" + sex + "\t" + age + "\t" + address + "\t" + job;
	}
	public  int show1() {
		return 233;
	}
}
public class TestRole {
	public static void main(String[] args) {
		Role guojing = new Role();
		System.out.println(guojing.show());
		Role yangkang = new Role("杨康", "男", 19, "浙江", "小王爷");
		System.out.println(yangkang.show());
		Role person = new Role();
		System.out.println(person.show());
		Role killer = new Role("杀手");
		System.out.println(killer.show());
		Role guoxiaotian = new Role("郭啸天", "男", "郭靖的父亲");
		System.out.println(guoxiaotian.show());
		
		
	}

}
