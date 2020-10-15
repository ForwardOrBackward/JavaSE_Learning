package day17;

import java.util.HashSet;
import java.util.Set;

class Student{
	private int no;
	private String name;
	private int age;
	public Student(int no, String name, int age) {
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
		return "Student [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
/*	@Override
	public int hashCode() {
	//          40*31  +  20
	//          20*31  +  40
	//          30*31  +  30  
		return no + name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// this , obj
		Student stu = (Student)obj;
		return this.no == stu.no && this.name.equals(stu.name);// true
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		return true;
	}
	
}
public class TestSet {

	public static void main(String[] args) {
		Set<Student> stus = new HashSet<>();
		Student stu1 = new Student(11, "张三", 22);
		Student stu2 = new Student(11, "张三", 22);
		Student stu3 = new Student(33, "王五" , 23);
		stus.add(stu1);
		stus.add(stu2);
		stus.add(stu3);
		//遍历
		stus.forEach(System.out::println);

	}

}
