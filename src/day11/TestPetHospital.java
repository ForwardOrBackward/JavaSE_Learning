package day11;
class Pet{
	private String name;
	public Pet(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void eat() {System.out.println("吃 ");}
}
class Dog extends Pet{
	public Dog(String name) {
		super(name);
	}
	@Override
	public void eat() {
		System.out.println("小狗吃骨头");	
	}
	public void run() {
		System.out.println("小狗跑了");
	}
}
class Cat extends Pet{
	public Cat(String name) {
		super(name);
	}
	@Override
	public void eat() {
		System.out.println("小猫吃鱼");
	}
	public void play() {
		System.out.println("小猫去玩儿了");
	}
}
class PetHospital{
	//看病 Pet pet = wangwang; Pet pet = new Dog();
	public void treatment(Pet pet) {//多态 Pet pet = wangwang;
		System.out.println("给" + pet.getName() + "看病");
		pet.eat();
		//--------------
		// 父类    -》  子类
		if(pet instanceof  Dog) {
			Dog dog = (Dog)pet;
			dog.run();
		}else if(pet instanceof  Cat){
			Cat cat = (Cat)pet;
			cat.play();
		}
	}
}
public class TestPetHospital {
	public static void main(String[] args) {
		PetHospital hos = new PetHospital();//建立了医院 
		Dog wangwang = new Dog("旺旺");
		Cat xiaohua = new Cat("小花");
		
		hos.treatment(wangwang);
		hos.treatment(xiaohua);
		
	}

}
