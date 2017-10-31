//by this prog.download a file from server it may be of any type
import java.net.*;
import java.io.*;
public class FileClient {
	
	public static void main(String[] args)  throws Exception {
		Socket clt=new Socket ("127.0.0.1",1956);
		System.out.println("Connected to server ...");
		FileOutputStream fout =new FileOutputStream("d:\\client\\tt.jpg",false);
		//false mean over write the file if exist 
		InputStream in= clt.getInputStream();
		while(true)
		{
			int x=in.read();//read a byte from server
			if (x==-1)			//we are at the end 
			{
				break;
			}
			fout.write(x);   //write in sun.jpg at d;\
		}
		fout.close();
		in.close();
		System.out.println("File downloaded successfully ....");
	}

}
