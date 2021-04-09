package day19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

	public static void main(String[] args) throws IOException  {
		//1
		FileReader fr = new FileReader("d:/data/a.txt");
		//2.
		char [] crs = new char[5];
		fr.read(crs);
		String s = new String(crs);
		System.out.println(s);
		//3.
		fr.close();

	}

}
