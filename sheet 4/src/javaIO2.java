import java.io.InputStreamReader;
import java.io.BufferedReader;
import java .io.IOException;
public class javaIO2 {

	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader br =new BufferedReader(ir);
		
		double l=0,b=0,h=0,v=0,sa=0,sd=0;
		int f=1;
		do
		{
			f=1;
		try{
			System.out.println("Enter lenght:");
			l=Double.parseDouble(br.readLine());
			System.out.println("Enter breadth:");
			b=Double.parseDouble(br.readLine());
			System.out.println("Enter height:");
			h=Double.parseDouble(br.readLine());
			
		}
		catch(IOException e){
			
			System.out.println("IO error " +e.getMessage());
			System.exit(0);
			}
		}while(f==0);
v=l*b*h;
sa=2*(l*b+b*h+h*l);
sd=Math.sqrt(l*l+b*b+h*h);
System.out.println("the volume of cuboid "+v);
System.out.println("the surface area "+sa);
System.out.println("the sum of diagonal of cuboid "+sd);

}
}