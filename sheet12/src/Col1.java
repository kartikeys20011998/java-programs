//collection framework
//in this prog it gives a warning beacuse arraylist insist to take every value in string form
import java.util.*;
public class Col1 {
	public static void main(String[] args) {
		ArrayList al= new 	ArrayList();
		al.add("hello");
		al.add(32.4);
		al.add(345);
		al.add("bye");
		al.add(1,"jai ho");
		Iterator it=al.iterator();//Iterator interface reads values from arraylist 
		while(it.hasNext())
		{
			System.out.println(it.next());
			
		}
		System.out.println(al.get(1)); //print value for 1th element 
	}

}
/*for(i=0;i<5;i++)
{
System.out.println(al.set(i));
}
*/
