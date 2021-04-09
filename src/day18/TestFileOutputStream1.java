package day18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream1 {

	public static void main(String[] args) throws IOException  {
		//String s = "hello中文";
		//1.
		//          true 追加，  false是覆盖（默认）
		FileOutputStream fout = new FileOutputStream("d:/data/b.txt",true);
		//2.
		String s = "hello中文";
//		fout.write('h');
		byte [] b = s.getBytes();
		fout.write(b);
		//        (字节数组， 从什么位置写， 写几个字节）
//		fout.write(b, 2, 2);
		//3.
		fout.close();
	}

}
