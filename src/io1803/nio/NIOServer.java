package io1803.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


public class NIOServer {
	
	Selector selector = null;
	
	public static final int PORT = 6789;
	
	public NIOServer(){
		init();
	}
	
	/**
	 *  初始化 - 启动服务器
	 */
	public void init(){		
		try {
			//获得一个Selector选择器
			selector = Selector.open();
			//获得一个服务端的Channel
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//设置服务端线程为非阻塞
			ssc.configureBlocking(false);
			//绑定服务端的Channel使用的端口
			ssc.bind(new InetSocketAddress(PORT));
			//最重要的一步, 将服务端的channel注册到Selector, 关注的事件是accept,也就是
			//告诉selector我现在是空闲的,等待接收请求。
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("服务器初始化成功 ...... ");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  监听所有的请求(事件)
	 */
	public void listen(){
		//服务器一直循环接收所有请求
		while(true){
			try {
				//每隔一秒轮询一次, 检查有没有新注册的事件;
				selector.select(1000);
//				System.out.println("每隔一秒钟执行一次轮询，查看哪些Channel的IO准备就绪");
				//得到当前selector里的所有的事件
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				if(selectedKeys == null || selectedKeys.size() == 0){
					continue;
				}
				//用一个迭代器遍历所有的selectedKeys。
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				while(iterator.hasNext()){
					SelectionKey key = iterator.next();
					iterator.remove(); //对于一个准备使用的事件,立刻从迭代器里删除
					// read  accept 
					handleKey(key);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleKey(SelectionKey key) {

		//检验当前key是否合法,保证key还有效
		if(key.isValid()){
			
			// 检查客户端是不是一个OP_ACCEPT请求
			if(key.isAcceptable()){
				//OP_ACCEPT是接收请求,接收请求都是服务端请求的, 所以先获取到服务端的channel
				ServerSocketChannel server = (ServerSocketChannel)key.channel();
//				System.out.println(server + "-------");
				try {
					/*
					 * sc是客户端的channel
					 * accept()的作用就是服务端的channel尝试去获取客户端的channel,让服务器
					 * 和客户端 通过三次握手 建立起 连接
					 */
					SocketChannel client = server.accept();
//					System.out.println(client + "------");
					//将sc设置为异步模式,不设置成异步模式是无法注册的
					client.configureBlocking(false);
					//注册客户端channel的read请求到Selector。
					client.register(selector, SelectionKey.OP_READ);
					System.out.println("接收一个客户链接.....");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			// 检查客户端是不是一个OP_READ请求
			if(key.isReadable()){
				String result = "";
				SocketChannel client = (SocketChannel)key.channel();
				ByteBuffer bb = ByteBuffer.allocate(1024); 
				int length = 0;
				try {
					length = client.read(bb);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				String message = new String(bb.array(), 0,  length);
				System.out.println("receive client request message : " + message);
				
				if(message.equals("getNowDate")){
					result = getNowDate();
				}else{
					result = "error code";
				}
				
				writeDateToClient(client, result);
				
				/*// 处理过后的channel就失效了，所以清空小
				if (key != null) {
					key.cancel();
					if (key.channel() != null) {
						try {
							key.channel().close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("关闭 客户端的 请求 链接 成功");
					}
				}*/
			}
		}
	}

	private void writeDateToClient(SocketChannel client, String result) {
		
		ByteBuffer sendMessageBuffer = ByteBuffer.allocate(1024);
		if(result != null && result.length() != 0){
			sendMessageBuffer.put(result.getBytes());
		}
		sendMessageBuffer.flip();
		try {
			client.write(sendMessageBuffer);
			System.out.println("服务端把数据响应给客户端");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getNowDate() {
		return new SimpleDateFormat("yy-MM-dd HH:MM:ss").format(new Date());
	}

	public static void main(String[] args) {
		
		NIOServer server = new NIOServer();
		
		server.listen();
	}
}
