package day20.socket3;

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
 * 3.0
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
		PrintWriter out = new PrintWriter(os,true);//
		
		//�� ������
		String sr,sw;
		while(true) {
			sr = in.nextLine();
			System.out.println("������˵��" + sr);
			if(sr.equals("end")) {
				break;
			}
		}
		
		//д  д��������
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("--�ͻ���˵��" );
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
