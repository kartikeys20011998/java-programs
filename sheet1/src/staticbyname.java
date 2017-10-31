class staticdemo{
	int c=12;
	static int a=42;//static variable
	protected static int b=8;
	static void callme(){//static method can use only static variable
		System.out.println("a="+a);
		//System.out.println("c="+c);
		
	}
	void callme1(){
		System.out.println("a="+a);
		System.out.println("c="+c);
		
	}
}

public class staticbyname {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
staticdemo ob=new staticdemo();
ob.callme1();//nonstatic method call by object
staticdemo.callme();//static method call with class name
System.out.println("b="+staticdemo.b);
System.out.println("a="+staticdemo.a);



	}

}
