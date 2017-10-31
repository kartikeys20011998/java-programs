//collection  framework
//every class in java directly or indirectly inherits the java.lang.objectclass
//Object[] ob =new Object[5];//create array of object like array of any variable 
//Object[[][] obd=new Object[5][4];
import  java.util.*;
public class Col {

	public static void main(String[] args) {
		Object ob=4;
		//here ob is using an integer 
		//above line working like this 
		//Object ob= new Integer (4);
		System.out.println(ob);
		ob="hello";// here ob is using  as string 
		System.out.println(ob);
		ob=4.56f;//here ob is using as float 
		System.out.println(ob);
		if (ob instanceof Double )// in last if the value is of double type in ob then it is true 
		{
			Double d=(Double)ob;
			double x=d.doubleValue();
			System.out.println(x);
		}
		else 
			System.out.println("obis not of double type ");

	}

}
