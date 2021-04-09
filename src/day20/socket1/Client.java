package day20.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * 1.0
 * */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建了一个客户端
		//                        服务器的IP，服务器的程序的端口号
		Socket socket = new Socket("127.0.0.1", 5678);
		
		//流：获得流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		//将socket的输入流用Scanner类来包装了一下。包装后,只是功能更多了而已, 真正进行读写的还是底层的socket流
		Scanner in = new Scanner(is);
		//将socket的输出流用PrintWriter流来包装一下。true表示刷新缓冲区,因为网
		//络编程如果数据被阻塞了, 不刷新根本写不过去
		PrintWriter out = new PrintWriter(os,true);
		
		//读 服务器
		String sr,sw;
		while(true) {
			sr = in.nextLine();
			System.out.println("服务器说：" + sr);
			if(sr.equals("end")) {
				break;
			}
		}
		
		//写  写到服务器。因为这里是客户端, 所以这里的所有输出(写)操作就是输出(写)到服务器。
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("--客户端说：" );
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
