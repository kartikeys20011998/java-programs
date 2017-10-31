import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
public class Client {
	public static void main(String[] args) throws Exception  {
		//because two programs are running on same comp sol ip address is "127.0.0.1"
		Socket client= new Socket("127.0.0.1",1956);
		//"127.0.0.1"ip address and 1956 is the port no of server where we are 
		//sending the request
		System.out.println("Connected to serevr ... ");
		BufferedReader br =new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter pw=new PrintWriter(client.getOutputStream());
		pw.println(4);//send 4 to server
		pw.println(6);//send  6 to server  
		pw.flush(); //done clear buffer to tell server now sending is over 
		int result=Integer.parseInt(br.readLine()); //recieved from server 
		System.out.println("Result="+result); //print on screen 
		// we can send data to server in aloop also 
		//loops in server and client must be of same time 
		pw.println(8);//send 8 to server 
		pw.println(12);//send 12 to server
		pw.flush();//done.. clear buffer to tell server now sending is over 
		 result=Integer.parseInt(br.readLine()); //recieved from server 
		System.out.println("Result="+result); //print on screen 
		 pw.println("hello"); //sending string to client 
		 pw.flush(); //flush buffer to tell client now sending  is over
		 
		String ss=br.readLine();//recieved from server 
		System.out.println(ss);// print on screen 
	}

}
