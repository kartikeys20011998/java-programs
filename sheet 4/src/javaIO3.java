import java.io.InputStreamReader;
import java.io.BufferedReader;
import java .io.IOException;

public class javaIO3 {

	
	public static void main(String[] args) {
		
		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader br =new BufferedReader(ir);
		String name=null;
		int age=0;

		try{
			System.out.println("Enter name:");
			name=br.readLine();
			
		}
		catch(IOException e){
		
			System.out.println("IO error " +e.getMessage());
			System.exit(0);
			}

		
			
				System.out.println("Enter age:");
try{
	age=Integer.parseInt(br.readLine());
			//convert string to int
			if(age<=0)//we can check here and throw tp any catch
				throw new NumberFormatException("invalid age must be greater than 0");
	//move to catch manually
}
catch(IOException e){
	
	System.out.println("IO error " +e.getMessage());
	System.exit(0);
	}
catch (NumberFormatException e){
	System.out.println("Invalid number"+e.getMessage());
	System.exit(0); //in getmessage it is passed "invalid age, 
	//must be greater than 0"

}
System.out.println("hello"+name);
System.out.println("you are"+age+"years old");
}
			
	}


