package day13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattren {

	public static void main(String[] args) {
		//1.指定 正则表达式
		Pattern p = Pattern.compile("[0-9]{6}");
		//2.指定要验证的字符串
		Matcher m = p.matcher("345678");
		//3.验证。匹配则输出true,不匹配则输出为false
		System.out.println(m.matches());//true
		int i1 = 1;
		Integer i2 = new Integer(1);

	}

}




