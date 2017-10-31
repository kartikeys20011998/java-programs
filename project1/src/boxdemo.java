class box
{
public	double l;
protected double b;
double h;
//by default variables are accessible from any where
//public data members are also accessible from anywhere
//protected are also accessible from anywhere
//but private members are not accessible from anywhere they are within member function
void volume()
	{
		System.out.println("the volume is "+(l*b*h));
	}
	
}
public class boxdemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	box b1=new box();
	box b2=new box();
	
	b1.l=10.5;
	b1.b=9.9;
	b1.h=10.0;
	
	b2.l=12.6;
	b2.b=11.4;
	b2.h=23.4;
	
	b1.volume();
	b2.volume();
	}


	}

