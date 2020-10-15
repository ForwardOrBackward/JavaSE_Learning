package day13;

interface Terrestrial {
	public int getLegNum();//腿的条数。
}
abstract class Animal {
	private String name = null;// 名字
	public Animal(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public abstract void shout();//动物叫
}
class Cat extends Animal implements Terrestrial {
	private int legNum = 0; // 腿的条数
	public Cat(String  name,int legNum) {
		super(name);
		this.legNum = legNum;
	}
	public void shout() {
		System.out.println("喵喵喵……");
	}
	public int getLegNum() {//实现接口的getLegNum()方法
		return legNum;		
	}
}
class Dolphin extends Animal {
	public Dolphin(String name) {
		super(name);		
	}
	public void shout() {
		System.out.println("海豚音……");
	}	
}
class Duck extends Animal implements Terrestrial {
	private int legNum = 0; // 腿的条数
	public Duck(String name,int legNum) {
		super(name);
		this.legNum = legNum;
	}
	public void shout() {
		System.out.println("嘎嘎嘎……");
	}
	public int getLegNum() {//实现接口的getLegNum()方法
		return legNum;
	}
}
public class TestAnimal {

	public static void main(String[] args) {
		Animal animals[] = new Animal[3];
		animals[0] = new Cat("加菲猫", 4);
		animals[1] = new Duck("唐小鸭", 2);
		animals[2] = new Dolphin("海豚奇奇");
		System.out.println("");
		System.out.println("动物名字\t\t腿的条数\t\t动物叫");
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
