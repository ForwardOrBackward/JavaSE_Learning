package day20.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ������
 * 2.0
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// ������һ�������� 
		//                                     �������Ķ˿�
		ServerSocket server = new ServerSocket(5678);
		
		while(true) {
			//���һ�� socket
			Socket socket = server.accept();
			
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
		}				
	}
}
