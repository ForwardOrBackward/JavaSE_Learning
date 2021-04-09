package day20.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器
 * 1.0
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// 创建了一个服务器 。记住服务器设置的端口要与客户端访问的端口一致
		//                                     服务器的端口
		ServerSocket server = new ServerSocket(5678);
		
		//获得一个 socket,注意这里不是新建一个socket流,而是接收来自客户端的流
		Socket socket = server.accept();
		
		//获得流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		Scanner in = new Scanner(is);
		PrintWriter out = new PrintWriter(os,true);
		
		//给客户端发送信息。因为这里是服务器, 所以这里的所有输出(写)操作就是输出(写)到客户端。
		out.println("客户端连接服务器成功");
		out.println("end");
		
		//读客户端
		String sr;
		while(true) {
			sr = in.nextLine();
			System.out.println("客户端说：" + sr);
			if(sr.equals("end")) break;
		}
		//关客户端。关的是与客户端的流。因为服务器自己本身并不新建流, 它只是接收来自客户端的流。
		socket.close();
		
		
	}

}
