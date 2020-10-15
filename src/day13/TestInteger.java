package day13;

public class TestInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		//装箱
		Integer i = new Integer(n);
		i = Integer.valueOf(n);
		//自动装箱
		i = n;//i = Integer.valueOf(n);
		//拆箱
		n = i.intValue();
		//自动拆箱
		n = i;//n = i.intValue();
		
		//-------------------------------------------
		//比较
		
		Integer i1 = 22; //自动装箱
		Integer i2 = 22; //自动装箱
		System.out.println(i1 == i2);//true
		
		Integer i3 = 456;// 等价于new Integer(456)
		Integer i4 = 456;//等价于 new Integer(456)
		System.out.println(i3 == i4);//false
		
		Integer i5 = new Integer(22);//直接新建对象
		Integer i6 = new Integer(22);//直接创建对象
		System.out.println(i5 == i6);//false
		
		//---------------------------------------------
		//查看范围
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		//类型转换--------------------------------------
		//字符串 转 数字
		String s = "123";
		int num = Integer.parseInt(s);//常用
//		Double.parseDouble(s)
//		Float.parseFloat(s)
		num = Integer.valueOf(s);
		num = new Integer(s).intValue();
		//数字 转 字符串
		s = num + "";//常用
		s = Integer.toString(num);
		s = String.valueOf(num);
		//-------------------------------------------
		//进制转换
		//十进制转二进制
		System.out.println(Integer.toBinaryString(5));//101
		//十进制转八进制
		System.out.println(Integer.toOctalString(15));//17
		//十进制转十六进制
		System.out.println(Integer.toHexString(15));//f
		//将2进制的101转换为十进制。注意valueOf第一个参数为待进制转换的数写成的字符串形式,第二个参数为该数的进制
		System.out.println(Integer.valueOf("101", 2));//5
		//将8进制的17转换为十进制。
		System.out.println(Integer.valueOf("17", 8));//15
		//将16进制的f转换为十进制。
		System.out.println(Integer.valueOf("f", 16));//15
		
		
		
		
	}

}
