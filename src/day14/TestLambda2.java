package day14;

interface Run{
	void run();//跑
}
class Demo3{
	public void check(Run run) {// Run run = new Dog()
		run.run();
	}
}
public class TestLambda2 {
	public static void main(String[] args) {
		Demo3 demo = new Demo3();
		demo.check(()->System.out.println("小猫跑的慢"));
		demo.check(()->System.out.println("小狗跑的快"));
		
		//
		Object obj1 = new Object();
		obj1 = new Run() {
			@Override
			public void run(){
				System.out.println("小猫跑的慢");
			}
		};
		
		Run run  = ()->System.out.println("小猫跑的慢");
		Object obj2 = run;
		
		Object obj3 = (Run)()->System.out.println("小猫跑的慢");
		
//		Dog dog = new Dog();
//		demo.check(dog);
//		Cat1 cat = new Cat1();
//		demo.check(cat);
		
//		demo.check(dog);
//		demo.check(cat);

	}

}
