//collection framework
//genric form
import java.util.*;
public class col2 {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		//here it will create an array for unsized 
		//it also insist to craete array elements to use as strings 
		//every data stored  as string 
		al.add("hello");
	
		al.add("32.4");
		al.add("345");
		al.add("bye");
		al.add(1,"jai ho");
		Iterator it =al.iterator();
		//iterator interface reads values from Arraylist
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println(al.get(1));
	}

}
