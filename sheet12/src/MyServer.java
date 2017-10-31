import java.net.*;
import java.io.*;
public class MyServer {

	public static void main(String[] args) throws Exception  {
		ServerSocket server=new ServerSocket(1956); //port can nbe anyone 
		System.out.println("Server started .......");
		Socket client =server.accept(); // wait  till the connection request arrives 
		System.out.println("Connection accepted ...");
 BufferedReader  br=new BufferedReader (new InputStreamReader(client.getInputStream()));
 PrintWriter pw=new PrintWriter(client.getOutputStream());
 int x=Integer.parseInt(br.readLine());//recieving 4 from client 
 int y=Integer.parseInt(br.readLine());//recieving 6 from client 
 pw.println(x+y);//sending result to client
 pw.flush();// flush buffer to  tell client now sending is oover 
 
  x=Integer.parseInt(br.readLine());//recieving 4 from client 
  y=Integer.parseInt(br.readLine());//recieving 6 from client 
 pw.println(x+y);//sending result to client
 pw.flush();// flush buffer to  tell client now sending is oover 
 
 String ss=br.readLine(); //recieving string from client 
	System.out.println(ss);// print on screen 
 pw.println("Yahoo"); //sending string to client 
 pw.flush(); //flush buffer to tell client now sending  is over
	}

}
