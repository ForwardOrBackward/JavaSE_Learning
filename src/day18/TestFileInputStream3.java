package day18;

import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream3 {

	public static void main(String[] args) {
		//1.����������
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("d:/data/a.txt");
			//2.��
			int temp;
			while((temp = fin.read() )!= -1) {
				System.out.print((char)temp);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//3.����
			if(fin != null) {
					try {
						fin.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}
	}

}
