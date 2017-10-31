//write data in binary mode take values from user
import java.io.*;
public class binaryio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
FileOutputStream fout=null;
DataOutputStream dout=null;
//DataInputStream fin=null;
//DataInputStream din=null;
//InputStreamReader ir1=new InputStreamReader(System.in);
InputStreamReader ir=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(ir);
String name=null;
int age=0,c;
float sal=0.00f;
char sex='m';
try{
	fout=new FileOutputStream ("test.dat",false);//dat extension used for binary mode
	dout=new DataOutputStream (fout);
}
catch(Exception e)
{
	System.out.println("invalid file path");
	
}
try{
	do{
		System.out.println("enter name:");
		try{
			name=br.readLine();
		}
		catch(IOException e)
		{
			System.out.println("ioerror"+e.getMessage());
		
		}
		try{
			System.out.println("enter age:");
			age=Integer.parseInt(br.readLine());
			if(age<0)
			throw new NumberFormatException("invalid age");
			InputStreamReader ir1=new InputStreamReader(System.in);
			//for making char lyk f or m we need to make a new diffrent object
			System.out.println("enter sex f/m");
			sex=(char)ir1.read();//read is which assoiciate with char
			System.out.println("enter salary");
			sal=Float.parseFloat(br.readLine());
			
			
		}
		catch(Exception e){
			System.out.println("invalid path");
		}
		
		
		
		
		
		
		dout.writeUTF(name);
		dout.writeInt(age);
		dout.writeChar(sex);
		dout.writeFloat(sal);
		System.out.println("1.want to enter more");
		System.out.println("2.exit");
		c=Integer.parseInt(br.readLine());
		
	}while(c==1);
	
}
catch(IOException e)
	{}
finally
{
	try{
		dout.close();
		fout.close();
		
	}catch(IOException e){
		System.exit(0);
	}
}

}
}