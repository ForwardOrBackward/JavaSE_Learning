package day20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TestURL2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("https://www.baidu.com/?tn=40020637_7_oem_dg");
		InputStream is = url.openStream();
		FileOutputStream fout = new FileOutputStream("D:/ä¯ÀÀÆ÷ÏÂÔØ/image.html");
		
		int temp;
		while((temp = is.read()) != -1) {
			fout.write(temp);
		}
		fout.close();
		is.close();
	}

}
