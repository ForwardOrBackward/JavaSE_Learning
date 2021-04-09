package day20.socket3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器
 * 3.0
 */
class SubThread implements Runnable{
	Socket socket;
	SubThread(Socket socket){
		this.socket = socket;
	}
	public void run() {
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Server {
	public static void main(String[] args) throws IOException {
		// 创建了一个服务器 
		//                                     服务器的端口
		ServerSocket server = new ServerSocket(5678);
		while(true) {//循环是为了不断创造出线程接收每个客户端发来的socket, 以保证每个新客户端想访问服务器时都能及时访问到。
			/*
			 * 为了保证每个线程接收到的是来自不同客户端的socket,而不是多个线程抢占同一个socket, 必须
			 * 要把 server.accept()方法放在这里, 然后通过构造参数传给线程, 
			 * 我们都知道server.accept()在没有接收到socket之前会一直阻塞, 这也保证了该循环不会无脑的一直循环执行,
			 * 导致生成了一堆不使用线程,浪费资源, 有一个socket过来请求访问服务器, 服务器就创造一个线程, 这样当然更佳,
			 * 所以,不能把下面这行语句放在run()方法里,否则就会出现:大量线程被创造出来了都在等待接收socket。
			 */
			Socket socket = server.accept();
			
			SubThread sub = new SubThread(socket);
			//由于创建子线程对象的语句放在了一个循环里, 所以这里会不断创建新的线程
			Thread t = new Thread(sub); 
			t.start();
		}				
	}
}
