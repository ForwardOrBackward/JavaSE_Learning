package day20.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器
 * 2.0
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// 创建了一个服务器 
		//                                     服务器的端口
		ServerSocket server = new ServerSocket(5678);
		
		while(true) {
			//获得一个 socket
			Socket socket = server.accept();
			
			//获得流
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			Scanner in = new Scanner(is);
			PrintWriter out = new PrintWriter(os,true);
			
			//给客户端发送信息
			out.println("客户端连接服务器成功");
			out.println("end");
			
			//读客户端
			String sr;
			while(true) {
				sr = in.nextLine();
				System.out.println("客户端说：" + sr);
				if(sr.equals("end")) break;
			}				
			socket.close();//关客户端
		}				
	}
}
