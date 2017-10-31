class test{
	int a;
	public int b;
	private int c;
	void setc( int i)
	{//to give value to c
		c=i;
	}
	int getc()
	{//to print value of c
		return c;
	
	}
}
public class accesstest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
test ob=new test();
ob.a=10;
ob.b=15;
//ob.c=29;
ob.setc(100);
System.out.println("a="+ob.a+"b="+ob.b+"c="+ob.getc());

	}

}
