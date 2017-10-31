//collectipon framework
//hashtable
import java.util.*;
class Data 
{
	String name;
	int age ;
	double sal;
	Data(String name, int age,double s)// constructor of data 
	{
		this.name=name;
		this.age=age;
		sal=s;
	}
	void show() //function show 
	{
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("sal : "+sal);
		System.out.println("--------------");
	}
}
public class Col4 {

	public static void main(String[] args) {
		Hashtable<String,Integer> ht=new Hashtable<String,Integer>();
		//hashtable is a table that stores two things first is key string second is data 
		ht.put("YK Goel", 1952);
		//above is table's first row 
		//here  YK Goel is key and 1952 is data 
		ht.put("Himanshu", 1985);
		//above is table's second row 
		System.out.println(ht.get("YK Goel"));
		//here it search for key YK Goel and print its data 1952
		System.out.println(ht.get("Himanshu"));
		//here it search for key Himanshu and print its data 1985
		Hashtable<String,Data> ob=new Hashtable<String,Data>();
		//here we are storing object of data class with key string 
		ob.put("YK Goel",new Data("Yogesh Kumar Goel ",55,12345));
		//we are storing here YK Goel as kry and creating a object of data and passing values 
		//Yogesh Kumar Goel and 55 to const function
		ob.put("Himanshu", new Data ("Himanshu Gupta ",22,66666));
		//we are storing herem Himanshu as key and creating an object of passed values stores in both objects 
		Data d= ob.get("YK Goel");
		//create object d and pass  YK Goel key it search in hashtable and print
		// both the values on screen 
		d.show();
		d=ob.get("Himanshu");
		d.show();
		
		
	}

}
