package day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	private String name;
	private int age; 	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
public class TestObjectOutputStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//把对象 存到 文件中,即序列化
		//1.
		FileOutputStream fout = new FileOutputStream("d:/data/obj.txt");
		ObjectOutputStream objFout = new ObjectOutputStream(fout);
		//2.
		Person zhangsan = new Person("张三", 22);
		objFout.writeObject(zhangsan);
		//3.
		objFout.close();
		
		//---------------读----------------------------------------
		//把 文件中的对象还原, 即反序列化
		//1
		FileInputStream fin = new FileInputStream("d:/data/obj.txt");
		ObjectInputStream objFin = new ObjectInputStream(fin);
		//2.
		Person stu = (Person)objFin.readObject();
		System.out.println(stu.getName() + "," + stu.getAge());
		//3.
		objFin.close();
		
	}

}
