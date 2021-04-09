package day20.socket3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ������
 * 3.0
 */
class SubThread implements Runnable{
	Socket socket;
	SubThread(Socket socket){
		this.socket = socket;
	}
	public void run() {
		try {
			//�����
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			Scanner in = new Scanner(is);
			PrintWriter out = new PrintWriter(os,true);		
			//���ͻ��˷�����Ϣ
			out.println("�ͻ������ӷ������ɹ�");
			out.println("end");			
			//���ͻ���
			String sr;
			while(true) {
				sr = in.nextLine();
				System.out.println("�ͻ���˵��" + sr);
				if(sr.equals("end")) break;
			}			
			socket.close();//�ؿͻ���
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Server {
	public static void main(String[] args) throws IOException {
		// ������һ�������� 
		//                                     �������Ķ˿�
		ServerSocket server = new ServerSocket(5678);
		while(true) {//ѭ����Ϊ�˲��ϴ�����߳̽���ÿ���ͻ��˷�����socket, �Ա�֤ÿ���¿ͻ�������ʷ�����ʱ���ܼ�ʱ���ʵ���
			/*
			 * Ϊ�˱�֤ÿ���߳̽��յ��������Բ�ͬ�ͻ��˵�socket,�����Ƕ���߳���ռͬһ��socket, ����
			 * Ҫ�� server.accept()������������, Ȼ��ͨ��������������߳�, 
			 * ���Ƕ�֪��server.accept()��û�н��յ�socket֮ǰ��һֱ����, ��Ҳ��֤�˸�ѭ���������Ե�һֱѭ��ִ��,
			 * ����������һ�Ѳ�ʹ���߳�,�˷���Դ, ��һ��socket����������ʷ�����, �������ʹ���һ���߳�, ������Ȼ����,
			 * ����,���ܰ���������������run()������,����ͻ����:�����̱߳���������˶��ڵȴ�����socket��
			 */
			Socket socket = server.accept();
			
			SubThread sub = new SubThread(socket);
			//���ڴ������̶߳������������һ��ѭ����, ��������᲻�ϴ����µ��߳�
			Thread t = new Thread(sub); 
			t.start();
		}				
	}
}
