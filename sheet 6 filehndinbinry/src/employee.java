import java.io.*;
public class employee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//FileOutputStream fout=null;
//DataOutputStream dout=null;
FileInputStream fin=null;
DataInputStream din=null;

FileWriter fw=null;
BufferedWriter bw=null;
String name="";
int age=0;
char sex;
float salary=0.0f;
try{
	//fw=new FileWriter("employee1.txt",false);
	fw=new FileWriter("employee1.txt",true);
	bw=new BufferedWriter(fw);
	
}
catch(Exception e)
{
	System.out.println("cant ewrite to file");
	
}
try{
	fin=new FileInputStream("test.dat");
	din=new DataInputStream(fin);
	while(true)
	{
		name=din.readUTF();
		if(name==null)
			break;
		age=din.readInt();
		sex=din.readChar();
		salary=din.readFloat();
		bw.write("name of employee: "+name);
		bw.newLine();
		bw.write("age of employee: "+age);
		bw.newLine();
		bw.write("sex of  employee: "+sex);
		bw.newLine();
		bw.write("slary of employee: "+salary);
		bw.newLine();
		bw.newLine();
		bw.newLine();
		System.out.println("name of employee: "+name);
		
		System.out.println("age of employee: "+age);
		
		System.out.println("sex of  employee: "+sex);
		
		System.out.println("slary of employee: "+salary);
		
	}
}
catch(Exception e){
	System.out.println("invalid path");
}
finally
{
	try
	{
		bw.close();
		fw.close();
		
	}catch(IOException e){
		//System.exit(0);
	}
	
}
	}

}
