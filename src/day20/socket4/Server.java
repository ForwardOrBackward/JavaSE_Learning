package day20.socket4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ������
 * 4.0
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// ������һ�������� 
		//                                     �������Ķ˿�
		ServerSocket server = new ServerSocket(5678);
		
		//���һ�� socket
		Socket socket = server.accept();
		
		//�����
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		Scanner in = new Scanner(is);
		PrintWriter out = new PrintWriter(os,true);
		Scanner input = new Scanner(System.in); //���Ǳ���2���˸��ӿ���̨�������System.in��
		//���ͻ��˷�����Ϣ
		out.println("�ͻ������ӷ������ɹ�");
		
		//���ͻ��˺�д�ͻ��ˡ�����2���˸�д�ͻ���
		String sr,sw;
		while(true) {
			sr = in.nextLine();
			System.out.println("�ͻ���˵��" + sr);
			System.out.print("--�������أ�" );
			sw = input.next(); //������һ��ʵʱ�ؿͻ��˻�����䡣�����˷�������ͻ��˵Ļ�����
			out.println(sw); //�����������Ȼ��socket�������ͨ����װ��out������ͻ��ˡ�
			if(sw.equals("end")) break;
		}
		
		socket.close();//�ؿͻ���
		
		
	}

}
