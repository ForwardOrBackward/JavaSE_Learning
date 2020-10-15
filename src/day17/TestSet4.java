package day17;

import java.util.Set;
import java.util.TreeSet;

class Employee implements Comparable<Employee>{
	private int no;
	private String name;
	private int age;
	public Employee(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Employee [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Employee o) {
		return this.no - o.no;
	}	
}
public class TestSet4 {
	public static void main(String[] args) {
		Set<Employee> set = new TreeSet<>((n1,n2)-> n2.getNo() - n1.getNo());
		Employee zhangsan = new Employee(11, "张三", 22);
		Employee lisi = new Employee(11, "李四", 23);
		Employee wangwu = new Employee(11, "王五", 21);
		set.add(zhangsan);
		set.add(lisi);
		set.add(wangwu);
		set.forEach(System.out::println);//Employee [no=11, name=张三, age=22]

	}

}
