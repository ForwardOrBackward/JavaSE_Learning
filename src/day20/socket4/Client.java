package day20.socket4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * �ͻ���
 * 4.0
 * */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//������һ���ͻ���
		//                        ��������IP���������ĳ���Ķ˿ں�
		Socket socket = new Socket("127.0.0.1", 5678);
		
		//���������
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//��װ
		Scanner in = new Scanner(is);
		PrintWriter out = new PrintWriter(os,true);
		Scanner input = new Scanner(System.in); //������2Ҳ�еĴӿ���̨�������System.in��
		//�� д
		String sr,sw;
		while(true) {
			sr = in.nextLine();
			System.out.println("������˵��" + sr);
			System.out.print("--�ͻ��˻أ�" );
			sw = input.next(); 
			//д�������� 
			out.println(sw);
			if(sw.equals("end")) {
				break;
			}
		}
		
		socket.close();
		
	}

}
