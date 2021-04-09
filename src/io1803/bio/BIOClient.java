package io1803.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *  客户端程序
 */
public class BIOClient {

	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			socket = new Socket("localhost", BIOServer.PORT);
//			socket = new Socket(args[0], BIOServer.PORT);
			System.out.println("建立连接成功。。。。");
		} catch (UnknownHostException e) {
			System.out.println("解析主机名失败");
		} catch (IOException e) {
			System.out.println("建立连接失败");
		}
		
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
			InputStream inputStream = socket.getInputStream();
			/// OutputStream提供了一个媒介，让服务端可以发送结果数据返回给客户端
			OutputStream outputStream = socket.getOutputStream();
			
			//InputStreamReader的作用就是把输入字节流转换为输入字符流
			in = new BufferedReader(new InputStreamReader(inputStream));
			//后面的true表示每次输出完后会自动flush。
			out = new PrintWriter(outputStream, true);
			
		} catch (IOException e) {
			System.out.println("和服务端交互的输入输出流获取失败......");
		}
		
		// 客户端发送请求
		out.println("xxx");
		out.println("getNowDate");
		//out.println(args[1]);
		
		// 接收服务端返回的结果。readLine就是服务端返回的字符串的一行
		String readLine = null;
		try {
			readLine = in.readLine();
		} catch (IOException e) {
			System.out.println("读取数据失败");
		}
		System.out.println("接收到服务器返回的结果是： " + readLine);
			
		CloseUtil.closeReader(in);
		CloseUtil.closeWriter(out);
		CloseUtil.closeSocket(socket);
	}
}
