package day8;
class Role{
	private String name;
	private int age;
	private String sex;
	//��������ʼ��
	private String address = "���ɹ�";
	private String job;

	public  Role() {
		this.name = "����";
//		this.address = "���ɹ�";
	}
	public Role(String job) {
		this();//�޲�
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
//		this.address = "���ɹ�";
//		this("����","��","����");
	}
	//�����:�����
	{
		this.address = "���ɹ�";
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
		Role yangkang = new Role("�", "��", 19, "�㽭", "С��ү");
		System.out.println(yangkang.show());
		Role person = new Role();
		System.out.println(person.show());
		Role killer = new Role("ɱ��");
		System.out.println(killer.show());
		Role guoxiaotian = new Role("��Х��", "��", "�����ĸ���");
		System.out.println(guoxiaotian.show());
		
		
	}

}
