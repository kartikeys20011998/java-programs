import java.net.*;
import java.io.*;
public class CheckAvailablePorts {
	public static void main(String[] args) throws Exception  {
		for(int i=1;i<=1024;i++)
		{
			//in total 65565 ports 
			//25 no port for ftp
			//80 no port for http
			ServerSocket server=null;
			boolean available =true;
			try
			{
				server=new ServerSocket(i);
			}
			catch(Exception e)
			{
				available=false;
			}
			System.out.println("Port: "+i+"status="+available);
			//if true mens available 
			//false not available 
			
		}
	}

}
