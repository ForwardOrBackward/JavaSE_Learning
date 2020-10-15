package day16;

import java.util.Arrays;
import java.util.Comparator;
class Student implements Comparable<Student>{
	private int no;
	private String name;
	private int score;
	private int age;
	public Student(int no, String name,int score,int age) {
		this.no = no;
		this.name = name;
		this.score = score;
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
	public int getScore() {
		return score;
	}
	
	
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", score=" + score + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Student stu) {
		//升序比较规则
		// this  stu------------------------------
	/*	if(this.no > stu.no) {
			return 1;//返回一个正数
		}else if(this.no < stu.no ) {
			return -1;//返回负数
		}else {
			return 0;
		}*/
//		return this.no - stu.no;
		//-------------------字符串-------------------
	/*	if(this.name.compareTo(stu.name) > 0) {
			return 1;
		}else if(this.name.compareTo(stu.name) < 0) {
			return -1;
		}else {
			return 0;
		}*/
//		return this.name.compareTo(stu.name);
	//--------------降序比较-----------------------------------
/*		if(this.score > stu.score) {
			return -1;
		}else if(this.score < stu.score) {
			return 1;
		}else {
			return 0;
		}*/
		return stu.score - this.score;
	}
	
	
}
//自定义的比较器
/*class MyComparator implements Comparator<Student>{
	@Override
	public int compare(Student stu1, Student stu2) {
		//升序比较的规则-------------------------------------
		//stu1,stu2
		if(stu1.getNo() > stu2.getNo()) {
			return 1;//正数
		}else if(stu1.getNo() < stu2.getNo()) {
			return -1;
		}else {
			return 0;
		}
		return stu1.getNo() - stu2.getNo();
		//----------------------------------------------------
	}
	
}*/
public class TestComparable {

	public static void main(String[] args) {
		Student stu1 = new Student(11, "zhangsan",88,22);
		Student stu2 = new Student(33, "zhangsan",99,20);
		Student stu3 = new Student(22, "wangwu",100,25);
		Student [] stus = {stu1,stu2,stu3};
//		Arrays.sort(stus);
//		MyComparator com = new MyComparator();
//		Arrays.sort(stus, com);
		/*Arrays.sort(stus, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getNo() - o2.getNo();
			}	
		});
		Arrays.sort(stus, (s1,s2)->s1.getNo() - s2.getNo());
		Arrays.sort(stus, (s1,s2)-> s2.getNo() - s1.getNo());*/
		Arrays.sort(stus, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
	/*				if(o1.getName().compareTo(o2.getName()) > 0) {
				return 1;
				}else if(o1.getName().compareTo(o2.getName()) < 0) {
					return -1;
				}else {//相等
					if(o1.getAge() > o2.getAge()) {
						return 1;
					}else if(o1.getAge() < o2.getAge()) {
						return -1;
					}else {
						return 0;
					}
				}*/
				if(o1.getName().compareTo(o2.getName()) == 0) {
					return o1.getAge() - o2.getAge();
				}
				return o1.getName().compareTo(o2.getName());
				
			}
			
		});
		Arrays.stream(stus).forEach(System.out::println);
		
/*		int [] arr = {11,35,76,13,7};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		String [] strs = {"aa","xx","cc"};
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));//[aa, cc, xx]
*/		

		
	}

}
