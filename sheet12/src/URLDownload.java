//by this program download a file from internet it may be of any type 
import java.net.*;
import java.io.*;
public class URLDownload {

	public static void main(String[] args) throws Exception {
		URL ur= new URL("http://localhost:8080/test/Sun.jpg");
		//URL ur= new URL("http://localhost:8080/test/Sun.jpg");
		//write here full site address of file 
		System.out.println("Connected  to url....");
		URLConnection con =ur.openConnection();
		FileOutputStream fout =new FileOutputStream("d:\\sun.jpg",false);
		InputStream in=con.getInputStream();
		while(true)
		{
			int x=in.read();  //read a byte from server
			if(x==-1)
			{
				break;       //we are at end 
			}
			fout.write(x);   // write  in sun.jpg at d:\
			
	}
		fout.close();
		in.close();
		
		System.out.println("File downloaded successfully ... ");

	}

}
