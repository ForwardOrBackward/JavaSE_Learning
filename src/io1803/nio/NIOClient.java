package io1803.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class NIOClient {
	
	private Selector selector = null;
	
	public NIOClient(){
		init();
	} 
	
	public void init(){
		
		SocketChannel client = null;
		try {
			selector = Selector.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			client = SocketChannel.open();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_CONNECT);
			client.connect(new InetSocketAddress("localhost", NIOServer.PORT));
			
			System.out.println("启动客户端  并且连接上");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		NIOClient client = new NIOClient();
		
		client.listen();
	}
	
	private volatile boolean stop = false;

	private void listen() {
		
		while(!stop){
			try {
				selector.select(1000);
				System.out.println("客户端每隔一秒钟轮询一次。  client");
				
				Set<SelectionKey> keys = selector.selectedKeys();
				if(keys == null || keys.size() == 0){
					continue;
				}
				
				Iterator<SelectionKey> iterator = keys.iterator();
				while(iterator.hasNext()){
					SelectionKey key = iterator.next();
					iterator.remove();
					handleKey(key);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleKey(SelectionKey key) {
		
		System.out.println("handleKey");

		if(key.isValid()){
			SocketChannel client = (SocketChannel)key.channel();
			boolean finishConnect = false;
			if(key.isConnectable()){
				try {
					finishConnect = client.finishConnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if(finishConnect){
					System.out.println("链接建立成功");
					writeDateToServer(client);
					try {
						client.register(selector, SelectionKey.OP_READ);
					} catch (ClosedChannelException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("服务器链接不上。 直接放弃");
					System.exit(1);
				}
			}
			
			if(key.isReadable()){
				System.out.println("正在执行读取结果数据..... ");
				ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
				int length = 0;
				try {
					length = client.read(receiveBuffer);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String result = new String(receiveBuffer.array(), 0, length);
				System.out.println("接收到服务端返回的结果：" + result);
				
				
				
				
				try {
					Thread.sleep(5000);
					client.register(selector, SelectionKey.OP_READ);
					writeDateToServer(client);
				} catch (ClosedChannelException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				
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
				
//				stop();
			}
		}
	}
	
	public void stop(){
		stop = true;
	}

	private void writeDateToServer(SocketChannel client) {
		ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
		String[] command = new String[]{"getNowDate","abc","xxxx"};
		Random r = new Random();
		sendBuffer.put(command[r.nextInt(command.length)].getBytes());
		sendBuffer.flip();
		try {
			client.write(sendBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("客户端 给 服务端 发送数据成功");
	}
}
