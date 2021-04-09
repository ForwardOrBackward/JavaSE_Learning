package io1803.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  服务端
 */
public class BIOServer {
	
	public static final int PORT = 6789;

	public static void main(String[] args) {	
		ServerSocket ss = null;
		try {
			 ss = new ServerSocket(PORT);
			System.out.println("服务端已经启动！！ 正在监听  " + PORT + " 端口");
		} catch (IOException e) {
			System.out.println("服务端启动异常！！！！！！");
		}
		
		// 等待所有的客户端请求
		while(true){	
			// 客户端发送过来了TCP请求，服务端要处理这个请求
			Socket clientSocket = null;
			try {			
				//accept(); 方法是阻塞的。这个方法会一直阻塞，直到有客户端发送请求连接之后才能返回		
				clientSocket = ss.accept();						
				System.out.println("服务器接收到一个客户端连接请求");
			} catch (IOException e) {
				System.out.println("服务端和客户端建立连接失败！！！");
			}
			
			/*
			 * TaskThread就是一个Runnable的实现类。每次接收到客户端的一个请求的时候，就初始
			 * 化一个新的线程来执行这个请求
			 * 
			 * 这样做会有两个问题: 
			 * 1、如果客户单的请求数据，过了很长时间都没有发送过来，那么这个线程就会一直运行着，但是又不做
			 * 任何事只是等待客户端发送数据过来。
			 * 2、既然每一个请求都初始化一个线程进行服务，那么并发量如果很大呢？也就是说客户端如果很多呢?
			 * 这样也是会出现问题的,毕竟服务器的资源是有限的，不能无限制的去接收客户端的请求
			 */
			new Thread(new TaskThread(clientSocket)).start();			
		}	
	}
	
	
	
	/**
	 *  TaskThread是属于服务端的,是专门用来处理  客户端请求的线程类。每有一个新客户端就生成一个新线程
	 */
	public static class TaskThread implements Runnable {
		
		private  Socket clientSocket = null;
		public TaskThread(Socket clientSocket){
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			/*
			 *  BufferedReader和PrintWriter用来包装 inputStream  和  outputStream的
			 *  包装的目的是为了让程序更简单, 因为我们接下来输入的内容都是字符, 让字符流来处理更加方便
			 */
			BufferedReader in = null;
			PrintWriter out = null;			
			try {
				/*
				 * inputStream 和  outputStream 都是建立在  clientSocket 这个 TCP 连接之上
				 */
				//InputStream提供了一个媒介，让服务端程序可以通过这个媒介接收客户端发送过来的请求或数据
				InputStream inputStream = clientSocket.getInputStream();
				//OutputStream提供了一个媒介，让服务端可以发送结果数据返回给客户端
				OutputStream outputStream = clientSocket.getOutputStream();
				
				//InputStreamReader的作用就是把输入字节流转换为输入字符流
				in = new BufferedReader(new InputStreamReader(inputStream));
				//后面的true表示每次输出完后会自动flush。
				out = new PrintWriter(outputStream, true);
			} catch (IOException e) {
				System.out.println("和客户端交互的输入输出流获取失败......");
			}
					
			// 服务端先接收客户端请求。readLine就是客户端发送过来的请求的字符串的一行
			String readLine = null;
			try {						
				//输入流的readLien()方法也是阻塞的。只有readLine()方法读到了一行,方法才会
				//返回,代码才能继续往下执行
				readLine = in.readLine();
				System.out.println("服务器接收到客户端的请求：" + readLine);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// 处理请求
			String response = handleRequest(readLine);
			
			// 响应给客户端
			out.println(response);
			System.out.println("服务端给客户端发送响应结果：" + response);
			
			CloseUtil.closeReader(in);
			CloseUtil.closeWriter(out);
			CloseUtil.closeSocket(clientSocket);
		}
			
		/**
		 *  handleRequest负责处理请求, 也就是
		 *  借助DateTimeUtil.getNowDate()方法,返回一个当前日期
		 */
		public String handleRequest(String request){		
			if(request.equals("getNowDate")){
				return DateTimeUtil.getNowDate();
			}else{
				return "error code";
			}
		}
	}
}




/**
 * 模拟服务端的一个服务程序
 */
class DateTimeUtil {
	public static String getNowDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	public static void main(String[] args) {
		System.out.println(getNowDate());
	}
}
