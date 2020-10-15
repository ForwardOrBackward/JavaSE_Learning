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
	public void eat() {System.out.println("�� ");}
}
class Dog extends Pet{
	public Dog(String name) {
		super(name);
	}
	@Override
	public void eat() {
		System.out.println("С���Թ�ͷ");	
	}
	public void run() {
		System.out.println("С������");
	}
}
class Cat extends Pet{
	public Cat(String name) {
		super(name);
	}
	@Override
	public void eat() {
		System.out.println("Сè����");
	}
	public void play() {
		System.out.println("Сèȥ�����");
	}
}
class PetHospital{
	//���� Pet pet = wangwang; Pet pet = new Dog();
	public void treatment(Pet pet) {//��̬ Pet pet = wangwang;
		System.out.println("��" + pet.getName() + "����");
		pet.eat();
		//--------------
		// ����    -��  ����
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
		PetHospital hos = new PetHospital();//������ҽԺ 
		Dog wangwang = new Dog("����");
		Cat xiaohua = new Cat("С��");
		
		hos.treatment(wangwang);
		hos.treatment(xiaohua);
		
	}

}
