package day18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream1 {

	public static void main(String[] args) throws IOException  {
		//String s = "hello����";
		//1.
		//          true ׷�ӣ�  false�Ǹ��ǣ�Ĭ�ϣ�
		FileOutputStream fout = new FileOutputStream("d:/data/b.txt",true);
		//2.
		String s = "hello����";
//		fout.write('h');
		byte [] b = s.getBytes();
		fout.write(b);
		//        (�ֽ����飬 ��ʲôλ��д�� д�����ֽڣ�
//		fout.write(b, 2, 2);
		//3.
		fout.close();
	}

}
