package day13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattren {

	public static void main(String[] args) {
		//1.ָ�� ������ʽ
		Pattern p = Pattern.compile("[0-9]{6}");
		//2.ָ��Ҫ��֤���ַ���
		Matcher m = p.matcher("345678");
		//3.��֤��ƥ�������true,��ƥ�������Ϊfalse
		System.out.println(m.matches());//true
		int i1 = 1;
		Integer i2 = new Integer(1);

	}

}




