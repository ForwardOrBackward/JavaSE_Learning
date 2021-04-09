package io1803.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  服务端
 */
public class BIOServer2 {
	public static final int PORT = 6789;

	public static void main(String[] args) {
		
		MyThreadPoolExecutor pool = null;		
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(PORT);			 
			pool = new MyThreadPoolExecutor();			 
			System.out.println("服务端已经启动！！ 正在监听  " + PORT + " 端口");
		} catch (IOException e) {
			System.out.println("服务端启动异常！！！！！！");
		}
		
		// 等待所有的客户端请求
		while(true){
			
			// 客户端发送过来了TCP请求，服务端要处理这个请求
			Socket clientSocket = null;
			try {										
				clientSocket = ss.accept();												
				System.out.println("服务器接收到一个客户端连接请求");
			} catch (IOException e) {
				System.out.println("服务端和客户端建立连接失败！！！");
			}
			

			pool.execute(new TaskThread(clientSocket));
			
		}		
	}
		
	

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
				/**
				 * inputStream 和  outputStream 都是建立在  clientSocket 这个 TCP 连接之上
				 */
				// InputStream提供了一个媒介，让服务端程序可以通过这个媒介接收 客户端发送过来的请求/数据
				InputStream inputStream = clientSocket.getInputStream();
				// OutputStream提供了一个媒介，让服务端可以发送结果数据返回给客户端
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
		 * 
		 */
		public String handleRequest(String request){
			
			if(request.equals("getNowDate")){
				return DateTimeUtil.getNowDate();
			}else{
				return "error code";
			}
		}
	}
	
/**
 * 模拟服务端的一个服务程序
 */
static class DateTimeUtil {

	public static String getNowDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	public static void main(String[] args) {
		System.out.println(getNowDate());
	}
}

}