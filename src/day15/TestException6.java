package day15;


class AgeException extends Exception{
	private String str;
	AgeException(){}	
	AgeException(String str){
		this.str = str;
	}
	@Override
	public String getMessage() {
		return "message:" + str;
	}
	@Override
	public String toString() {
		return "toString:" + str;
	}
	@Override
	public void printStackTrace() {
		System.out.println("print:" + str);
	}	
}
class Person{
	private int age;
	private String sex;
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeException{
		if(age >= 18 && age <= 65) {
			this.age = age;
		}else {
			//抛异常
			throw new AgeException("年龄必须18-65之间");
		}
	}
}
public class TestException6 {
	public static void main (String[] args) {
		Person zhangsan = new Person();		
		try {
			zhangsan.setAge(345);
		} catch (AgeException e) {
//			e.printStackTrace();
//			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
}
