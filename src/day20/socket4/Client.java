package day20.socket4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * 4.0
 * */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建了一个客户端
		//                        服务器的IP，服务器的程序的端口号
		Socket socket = new Socket("127.0.0.1", 5678);
		
		//流：获得流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//包装
		Scanner in = new Scanner(is);
		PrintWriter out = new PrintWriter(os,true);
		Scanner input = new Scanner(System.in); //这是例2也有的从控制台输入的流System.in。
		//读 写
		String sr,sw;
		while(true) {
			sr = in.nextLine();
			System.out.println("服务器说：" + sr);
			System.out.print("--客户端回：" );
			sw = input.next(); 
			//写到服务器 
			out.println(sw);
			if(sw.equals("end")) {
				break;
			}
		}
		
		socket.close();
		
	}

}
