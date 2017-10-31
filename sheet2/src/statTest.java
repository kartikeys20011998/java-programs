
	

public class statTest {
	// it is also is function defination
	static void cube(int n){//this is a static fn. with main fn.
		System.out.println("cube="+n*n*n);
		
	}
	// above is the function defination
	void square(int n){//it is a non satatic fn. with main
		System.out.println("square="+n*n);
		
	}
	public static void main(String[] args) {

statTest.cube(5); //called by class name because it is static
cube(7);
//can be called directly as in same class
statTest t=new statTest(); //create object,t is the reference of object created by new command
t.square(6);
new statTest().square(3); //call fn square directly by class name
t=null;//here delete the ref.object by null
	}

}
