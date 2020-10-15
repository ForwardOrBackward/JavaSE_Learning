package day14;

class Cat{
	private double weight;
	public Cat(double weight) {
		this.weight = weight;
	}
	//内部类 (可以是任何访问修饰符,这里用的是默认访问修饰符)
	class CatBody{
		private String color;
		public CatBody(String color) {
			this.color = color;
		}
		public void show() {
			/*
			 * 内部类访问外部类成员，可以直接访问。因为每个内部类对象中都会隐含一个外部类对象。
			 * 可以通过 外部类.this.外部类成员 来调用, 所以这里的weight等价于Cat.this.weight
			 * 实际上,这里的color也等价于CatBoy.this.color,由于现在在CatBoy类中,
			 * 所以color也同时等价于this.color。color这两种等价写法在所有类中都适用,跟是不是内部
			 * 类无关,看后面的Cat.this.weight用法就知道了。
			 * 这里的weight并不等价于this.weight, 是因为现在是在CatBody类内部,虽然它是外部类Cat
			 * 的一个成员类,但当前在CatBody类内的情况下,当前的this指针就是指向CatBody类的,在哪个类
			 * 里,默认的this(即省略类名不写的this)就是指向当前类的,就是当前类对象的引用,所以这里不能写
			 * this.weight,因为CatBody类中没有weight成员。
			 * 
			 */
			System.out.println("颜色：" + color + weight);
		}
	}
	public void display() {
		//下面的Cat.this.weight也等价于this.weight和weight
		System.out.println("重量：" + Cat.this.weight);
		//外部类 要访问 其内部类的 数据 ，需要用内部类对象
		CatBody body = new CatBody("白色");
		body.show();		
	}	
}
public class TestInner1 {
	public static void main(String[] args) {
		//通过外部类来间接使用内部类里的东西
		Cat cat = new Cat(11.1);
		cat.display();
		/*
		 * 如果想要在别的类中直接创建内部类的对象并使用它,首先需要注意内部类的访问修饰符,
		 * 其次注意使用内部类穿件对象的方法如下。类名要用 外部类.内部类; new要用: 外部类对象.new
		 */
		Cat.CatBody body = cat.new CatBody("黑色");
		body.show();
		
		/*
		 * 第二种在别的类中直接创建内部类的对象的方式。和上面唯一的区别就是这种方式中,外部类使用的是
		 * 匿名对象 。
		 */		
		Cat.CatBody body1 = new Cat(22.2).new CatBody("黄色");
		body1.show();
	}

}
