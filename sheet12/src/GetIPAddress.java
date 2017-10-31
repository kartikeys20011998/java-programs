import java.net.*;
import java.io.*;
public class GetIPAddress {
	

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println("Address:"+ip.getHostAddress());
		System.out.println("Name:"+ip.getHostName());
		
		
		
		
		

	}

}
