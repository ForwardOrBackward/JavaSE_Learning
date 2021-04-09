package day20;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println(InetAddress.getLocalHost());// DESKTOP-BBVQN3Q/192.168.123.1
		InetAddress net = InetAddress.getByName("DESKTOP-BBVQN3Q");
		System.out.println(net.getHostName());//DESKTOP-BBVQN3Q	
		System.out.println(net.getHostAddress());//192.168.123.1
	}
	
}
