package day18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFileInputStrem1 {

	public static void main(String[] args) throws IOException {
		//读 把d:/data/a.txt 文件内容读取出来展示
//		File f = new File("d:/data/a.txt");
		//FileNotFoundException
//		FileInputStream fin = new FileInputStream(f);
		//1.创建流对象
		FileInputStream fin = new FileInputStream("d:/data/a.txt");
		//字符流： 处理流
		InputStreamReader reader = new InputStreamReader(fin);
		//2.读
		//IOException
	/*	System.out.println((char)fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());
		System.out.println(fin.read());//-1
*/		
		int temp;
		while((temp = reader.read() )!= -1) {
			System.out.print((char)temp);
		}
		//3.关流
		reader.close();
//		fin.close();
//		reader.close();
	}

}
