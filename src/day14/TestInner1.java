package day14;

class Cat{
	private double weight;
	public Cat(double weight) {
		this.weight = weight;
	}
	//�ڲ��� (�������κη������η�,�����õ���Ĭ�Ϸ������η�)
	class CatBody{
		private String color;
		public CatBody(String color) {
			this.color = color;
		}
		public void show() {
			/*
			 * �ڲ�������ⲿ���Ա������ֱ�ӷ��ʡ���Ϊÿ���ڲ�������ж�������һ���ⲿ�����
			 * ����ͨ�� �ⲿ��.this.�ⲿ���Ա ������, ���������weight�ȼ���Cat.this.weight
			 * ʵ����,�����colorҲ�ȼ���CatBoy.this.color,����������CatBoy����,
			 * ����colorҲͬʱ�ȼ���this.color��color�����ֵȼ�д�����������ж�����,���ǲ����ڲ�
			 * ���޹�,�������Cat.this.weight�÷���֪���ˡ�
			 * �����weight�����ȼ���this.weight, ����Ϊ��������CatBody���ڲ�,��Ȼ�����ⲿ��Cat
			 * ��һ����Ա��,����ǰ��CatBody���ڵ������,��ǰ��thisָ�����ָ��CatBody���,���ĸ���
			 * ��,Ĭ�ϵ�this(��ʡ��������д��this)����ָ��ǰ���,���ǵ�ǰ����������,�������ﲻ��д
			 * this.weight,��ΪCatBody����û��weight��Ա��
			 * 
			 */
			System.out.println("��ɫ��" + color + weight);
		}
	}
	public void display() {
		//�����Cat.this.weightҲ�ȼ���this.weight��weight
		System.out.println("������" + Cat.this.weight);
		//�ⲿ�� Ҫ���� ���ڲ���� ���� ����Ҫ���ڲ������
		CatBody body = new CatBody("��ɫ");
		body.show();		
	}	
}
public class TestInner1 {
	public static void main(String[] args) {
		//ͨ���ⲿ�������ʹ���ڲ�����Ķ���
		Cat cat = new Cat(11.1);
		cat.display();
		/*
		 * �����Ҫ�ڱ������ֱ�Ӵ����ڲ���Ķ���ʹ����,������Ҫע���ڲ���ķ������η�,
		 * ���ע��ʹ���ڲ��ഩ������ķ������¡�����Ҫ�� �ⲿ��.�ڲ���; newҪ��: �ⲿ�����.new
		 */
		Cat.CatBody body = cat.new CatBody("��ɫ");
		body.show();
		
		/*
		 * �ڶ����ڱ������ֱ�Ӵ����ڲ���Ķ���ķ�ʽ��������Ψһ������������ַ�ʽ��,�ⲿ��ʹ�õ���
		 * �������� ��
		 */		
		Cat.CatBody body1 = new Cat(22.2).new CatBody("��ɫ");
		body1.show();
	}

}
