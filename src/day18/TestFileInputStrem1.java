package day18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFileInputStrem1 {

	public static void main(String[] args) throws IOException {
		//�� ��d:/data/a.txt �ļ����ݶ�ȡ����չʾ
//		File f = new File("d:/data/a.txt");
		//FileNotFoundException
//		FileInputStream fin = new FileInputStream(f);
		//1.����������
		FileInputStream fin = new FileInputStream("d:/data/a.txt");
		//�ַ����� ������
		InputStreamReader reader = new InputStreamReader(fin);
		//2.��
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
		//3.����
		reader.close();
//		fin.close();
//		reader.close();
	}

}
