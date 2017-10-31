//how to input data from keyboard!
import java.io.InputStreamReader;//to read from keyboard
import java.io.BufferedReader;//read from buffer
import java .io.IOException;//for try and catch
public class javaIO {


	public static void main(String[] args) {
	
InputStreamReader ir=new InputStreamReader(System.in);
//make object ir for input
BufferedReader br =new BufferedReader(ir);
//make br for buffered read
String name=null;
int age=0;

try{
	System.out.println("Enter name:");
	name=br.readLine();
	
}
catch(IOException e){
	//must be written to check hardware failure
	//we can omit this try catch but java force to be written it
	System.out.println("IO error " +e.getMessage());
	System.exit(0);
	}

int f=1;
do
{
	f=1;
	try{
		System.out.println("Enter age:");
		age=Integer.parseInt(br.readLine());
		//convert string to int
		//we read any no as string and fn parseInt convert into integer
		//Float.parseFloat;
		//Long.parseLong;
		//Double.parseDouble;
		}
	catch (IOException e){
		//here e is created by java at run time if any eror occurs 
		//this catch must be written it catches any hardware problems
		System.out.println("IO error " +e.getMessage());
		System.out.println("invalid number enter again");
		//System.exit(0);//exit from the program
		f=0;
		}
	catch(NumberFormatException e){
		//this catch is for if we entered othrt then no
		System.out.println("Invalid number"+e.getMessage());
		System.out.println("Invalid numberentered again");
		//System.exit(0);//exit from the program
				f=0;
		}
}while(f==0);
	System.out.println("hello"+name);
	System.out.println("you are"+age+"years old");
	
	}
	}

	


