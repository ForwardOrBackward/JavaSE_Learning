package day13;

public class TestInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		//װ��
		Integer i = new Integer(n);
		i = Integer.valueOf(n);
		//�Զ�װ��
		i = n;//i = Integer.valueOf(n);
		//����
		n = i.intValue();
		//�Զ�����
		n = i;//n = i.intValue();
		
		//-------------------------------------------
		//�Ƚ�
		
		Integer i1 = 22; //�Զ�װ��
		Integer i2 = 22; //�Զ�װ��
		System.out.println(i1 == i2);//true
		
		Integer i3 = 456;// �ȼ���new Integer(456)
		Integer i4 = 456;//�ȼ��� new Integer(456)
		System.out.println(i3 == i4);//false
		
		Integer i5 = new Integer(22);//ֱ���½�����
		Integer i6 = new Integer(22);//ֱ�Ӵ�������
		System.out.println(i5 == i6);//false
		
		//---------------------------------------------
		//�鿴��Χ
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		//����ת��--------------------------------------
		//�ַ��� ת ����
		String s = "123";
		int num = Integer.parseInt(s);//����
//		Double.parseDouble(s)
//		Float.parseFloat(s)
		num = Integer.valueOf(s);
		num = new Integer(s).intValue();
		//���� ת �ַ���
		s = num + "";//����
		s = Integer.toString(num);
		s = String.valueOf(num);
		//-------------------------------------------
		//����ת��
		//ʮ����ת������
		System.out.println(Integer.toBinaryString(5));//101
		//ʮ����ת�˽���
		System.out.println(Integer.toOctalString(15));//17
		//ʮ����תʮ������
		System.out.println(Integer.toHexString(15));//f
		//��2���Ƶ�101ת��Ϊʮ���ơ�ע��valueOf��һ������Ϊ������ת������д�ɵ��ַ�����ʽ,�ڶ�������Ϊ�����Ľ���
		System.out.println(Integer.valueOf("101", 2));//5
		//��8���Ƶ�17ת��Ϊʮ���ơ�
		System.out.println(Integer.valueOf("17", 8));//15
		//��16���Ƶ�fת��Ϊʮ���ơ�
		System.out.println(Integer.valueOf("f", 16));//15
		
		
		
		
	}

}
