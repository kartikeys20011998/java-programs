//to import data from the key board and check its validity
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
//here we make a extra class javaIO4 and make a function show in this
//function we are doing
//all the work for input and output and call this function show in main class


public class javaIO4 {
	public static void show() throws IOException,NumberFormatException{
	//	public static void show(){//it will give error
		//here we are passing message that try and catch will
		//be used by calling class of this function
		//we can write try and catch here also but we want to give power to user
		//so he can write there own messages
		//here we make this class static to invoke this show fun directly
		InputStreamReader ir=new InputStreamReader(System.in);
		
		BufferedReader br =new BufferedReader(ir);
		
		String name=null;
		int age=0;
		System.out.println("Enter name:");
		name=br.readLine();
		System.out.println("Enter age:");
		age=Integer.parseInt(br.readLine());
		if(age<=0)//we can check here and throw to any catch
			throw new NumberFormatException("invalid age must be greater than 0");
//move to catch manually
		System.out.println("hello"+name);
		System.out.println("you are"+age+"years old");
		}
		public static void main(String ar[]){
			try{
				show();
			}
			catch (IOException e){
				System.out.println("Invalid number"+e.getMessage());
				System.exit(0);
			}
			catch(NumberFormatException e){
				
				System.out.println("Invalid number"+e.getMessage());
				System.exit(0);//in getMessage it is passed "invalid 
				//age must be greater than 0"
		}
	}

}
