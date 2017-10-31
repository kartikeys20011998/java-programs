class one{
	int x=1;
	void display(){
	System.out.println("x ="+x);
	
}
}
class two extends one{
	int y=2;
	void display(){
		System.out.println("y="+y);
		
	}
}

public class runtshow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
one o;
o=new two();
o.display();


	}

}
