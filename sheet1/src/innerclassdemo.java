class Outer
{
	int x=100;
	//inner class start here
	class Inner{
		int y=200;
		void display(){
			System.out.println("display:x="+x);
			//this inner class func is using outer class variable
			
		}
		void display1(){
			System.out.println("display;y="+y);
			
		}
	}//inner class closed here
	//outer class fn written below
	void test()
	{
		Inner inner=new Inner();
		inner.display();
		inner.display1();
		}
	
	//outer class fn
		void display2(){
	//		System.out.println("display:y="+y);
			System.out.println("display:x="+x);
			//call this function in main and check whether a outer class func can use inner
			//class variable or not.
		}
	
}

public class innerclassdemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Outer outer=new Outer();
outer.test();
outer.display2();


	}

}
