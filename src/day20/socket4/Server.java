package day20.socket4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器
 * 4.0
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// 创建了一个服务器 
		//                                     服务器的端口
		ServerSocket server = new ServerSocket(5678);
		
		//获得一个 socket
		Socket socket = server.accept();
		
		//获得流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		Scanner in = new Scanner(is);
		PrintWriter out = new PrintWriter(os,true);
		Scanner input = new Scanner(System.in); //这是比例2多了个从控制台输入的流System.in。
		//给客户端发送信息
		out.println("客户端连接服务器成功");
		
		//读客户端和写客户端。比例2多了个写客户端
		String sr,sw;
		while(true) {
			sr = in.nextLine();
			System.out.println("客户端说：" + sr);
			System.out.print("--服务器回：" );
			sw = input.next(); //多了这一句实时回客户端话的语句。增加了服务器与客户端的互动性
			out.println(sw); //这句输出语句依然是socket的输出流通过包装流out输出到客户端。
			if(sw.equals("end")) break;
		}
		
		socket.close();//关客户端
		
		
	}

}
