package io1803.bio;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/**
 * CloseUtil是关闭流的工具类, 主要用来关闭流。为什么要将关闭流做成工具类?
 * 因为每次关闭流都要进行抛异常, 会使得代码比较冗余,所以封装成一个类。
 */
public class CloseUtil {

	public static void closeReader(Reader reader) {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("关闭  reader 失败");
			}
			reader = null;
		}
	}

	public static void closeWriter(Writer writer) {
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("关闭  reader 失败");
			}
			writer = null;
		}
	}
		
	public static void closeSocket(Socket socket) {
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("关闭  reader 失败");
			}
			socket = null;
		}
	}
}
