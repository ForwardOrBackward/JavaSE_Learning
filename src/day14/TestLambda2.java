package day14;

interface Run{
	void run();//��
}
class Demo3{
	public void check(Run run) {// Run run = new Dog()
		run.run();
	}
}
public class TestLambda2 {
	public static void main(String[] args) {
		Demo3 demo = new Demo3();
		demo.check(()->System.out.println("Сè�ܵ���"));
		demo.check(()->System.out.println("С���ܵĿ�"));
		
		//
		Object obj1 = new Object();
		obj1 = new Run() {
			@Override
			public void run(){
				System.out.println("Сè�ܵ���");
			}
		};
		
		Run run  = ()->System.out.println("Сè�ܵ���");
		Object obj2 = run;
		
		Object obj3 = (Run)()->System.out.println("Сè�ܵ���");
		
//		Dog dog = new Dog();
//		demo.check(dog);
//		Cat1 cat = new Cat1();
//		demo.check(cat);
		
//		demo.check(dog);
//		demo.check(cat);

	}

}
