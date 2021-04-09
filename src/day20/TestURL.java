package day20;

import java.net.MalformedURLException;
import java.net.URL;
public class TestURL {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("http://127.0.0.1:5678/data/a.docx?id=1&page=2#hello");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getDefaultPort());//80
		System.out.println(url.getQuery());
		System.out.println(url.getRef());
	}

}
