//download a file from serever 
// by this programme send a file from server to client it may be of any type 
import java.net.*;
import java.io.*;
public class FileServer {

	public static void main(String[] args) throws Exception  {
			ServerSocket server=new  ServerSocket(1956);
			System.out.println("server started.....");
			Socket client=server.accept();//wait till the connection request arrives 
			System.out.println("Connection accepted...");
			//FileInputStream fin= new FileInputStream("c:\\data.txt");
			FileInputStream fin =new FileInputStream("c:\\server\\tt.jpg");
			//path of file 
			OutputStream out=client.getOutputStream();
			while (true)
			{
				int x=fin.read();//read a byte from file
				if(x==-1)  // we are at the end of the file 
					break;
			
			out.write(x);  //send byte to client 
			}
	
	out.close();
	fin.close();
	System.out.println("File sent successfully ... ");
}
}
