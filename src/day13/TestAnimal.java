package day13;

interface Terrestrial {
	public int getLegNum();//�ȵ�������
}
abstract class Animal {
	private String name = null;// ����
	public Animal(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public abstract void shout();//�����
}
class Cat extends Animal implements Terrestrial {
	private int legNum = 0; // �ȵ�����
	public Cat(String  name,int legNum) {
		super(name);
		this.legNum = legNum;
	}
	public void shout() {
		System.out.println("����������");
	}
	public int getLegNum() {//ʵ�ֽӿڵ�getLegNum()����
		return legNum;		
	}
}
class Dolphin extends Animal {
	public Dolphin(String name) {
		super(name);		
	}
	public void shout() {
		System.out.println("����������");
	}	
}
class Duck extends Animal implements Terrestrial {
	private int legNum = 0; // �ȵ�����
	public Duck(String name,int legNum) {
		super(name);
		this.legNum = legNum;
	}
	public void shout() {
		System.out.println("�¸¸¡���");
	}
	public int getLegNum() {//ʵ�ֽӿڵ�getLegNum()����
		return legNum;
	}
}
public class TestAnimal {

	public static void main(String[] args) {
		Animal animals[] = new Animal[3];
		animals[0] = new Cat("�ӷ�è", 4);
		animals[1] = new Duck("��СѼ", 2);
		animals[2] = new Dolphin("��������");
		System.out.println("");
		System.out.println("��������\t\t�ȵ�����\t\t�����");
		for (int i = 0; i < animals.length; i++){
			System.out.println(animals[i] instanceof Animal);
			if (animals[i] instanceof Terrestrial) {
				String name = animals[i].getName();
				int legNum = ((Terrestrial) animals[i]).getLegNum();
				System.out.print(name + "\t\t" + legNum + "\t\t");
				animals[i].shout();
			} else {
				String name = animals[i].getName();
				System.out.print(name + "\t\t" + 0 + "\t\t");
				animals[i].shout();
			}
		}

	}

}
