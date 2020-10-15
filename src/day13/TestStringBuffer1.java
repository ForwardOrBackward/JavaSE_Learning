package day13;

public class TestStringBuffer1 {

	public static void main(String[] args) {
		
		//�����޲ι��촴������Ļ�,�ַ�������Ӧ���ַ�����ĳ�ʼ���� Ϊ16���ַ�
		StringBuffer sf1 = new StringBuffer();
		System.out.println(sf1.capacity());//16
		//ʹ���ַ�����Ϊ������������Ļ�,��������Ϊ16+�ַ��������ĳ���
		StringBuffer sf2 = new StringBuffer("hello");
		System.out.println(sf2.capacity());//21
		//����sf1ĩβ׷���ַ���: ���׷�����,sf1�ĳ��Ȳ�����ԭ�����Ĵ�С,����������
		sf1.append("hello");//append����ֱ��׷�ӵ�sf1����,����д�� sf1 = sf1.append("hello");
		System.out.println(sf1);//hello
		System.out.println(sf1.capacity());//16	
		//����sf1ĩβ׷���ַ���: ���׷�����,sf1�ĳ��ȳ���ԭ�����Ĵ�С,��ֻ���½�һ���ַ����鴢��sf1�����ַ�����,ԭ�ַ������������
		sf1.append("+hellohellohellohello");
		System.out.println(sf1); //hello+hellohellohellohello
		System.out.println(sf1.capacity());//34
		
		StringBuffer sf3 = new StringBuffer(100);
		System.out.println(sf3.capacity());//100
		
		
//		StringBuffer sf = new StringBuffer();
//		System.out.println(sf.capacity());//16
//		sf.append("hello");
//		System.out.println(sf.capacity());//16
		
//		StringBuffer sf = new StringBuffer("hello");
//		sf.trimToSize();
//		System.out.println(sf.capacity());//5
		//------------���----------------------
		StringBuffer sf = new StringBuffer("hello");
		char [] crs = {'a','b','c'};
		//׷���ַ����顣��"hello"����׷���ַ�����
//		sf.append(crs);//helloabc
		//׷���ض���Χ���ַ�����,����Ϊ(��׷�ӵ��ַ�����,��ʼλ�ã�����)����"hello"����׷���ַ����� 
		sf.append(crs, 0, 2);//helloab
		System.out.println(sf);
		//����һ���ַ���   ����Ϊ������λ�� ����������ַ���)����"helloab"�в���һ���ַ���
		sf.insert(5, "���");
		System.out.println(sf);//"hello���ab"
		//�޸ĵ�ǰ�ַ����е�ĳ�ַ�,����Ϊ(Ҫ�޸ĵ�λ�ã��µ��ַ�)����"hello���ab"�޸�
		sf.setCharAt(5, 's');
		System.out.println(sf);//hello����ab		
		//ɾ��ָ��λ�õ��ַ�������(��ɾ����λ��)������ɾ��"hello����ab"ָ��λ�õ��ַ�
		sf.deleteCharAt(5);
		System.out.println(sf);//hello��ab
		//ɾ��ָ����Χ�ڵ��ַ�����,����[��ʼλ�ã���ֹλ�ã�,��������ҿ������䡣��ǰ�ַ���Ϊhello��ab"
		sf.delete(5, 8);
		System.out.println(sf);//hello
		//��ת��ǰ�ַ���
		sf.reverse();
		System.out.println(sf);//olleh
		System.out.println(System.currentTimeMillis());
	}

}
