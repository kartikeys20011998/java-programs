//collection framework
//generic form
import java.util.*;
public class Col3 {
	public static void main(String[] args) {
		//it also a array sort of linked list by default it is having 10 elements 
		//after that it create next 10 lelments 
		HashSet<String> al=new HashSet<String>();
		HashSet<Integer> al1=new HashSet<Integer>();
		//it also insist to create array elements to use as strings 
		//every data stored as string
		al.add("hello");
		al.add("32.4");
		al.add("345");
		al.add("bye");
		al.add("345");
		al.add("jai ho");
		al.add("345");
		al.remove("32.4");
		//it removes that element but array is of 10 elements 
		Iterator it= al.iterator();
		//iterator interface reads vales from arraylist
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		al1.add(10);//it will store this value by own genrated element address 
		al1.add(20);///it will store this value by own genrated element address 
		al1.add(30);//it will store this value by own genrated element address 
		System.out.println(al1);//by this line it will print full array 
		
		Iterator it1=al1.iterator();//iterator interface reads values arraylist 
		while(it1.hasNext())
		{
			System.out.println(it1.next());//now print array 
		}

	}

}
