class box1
{
	double l,b,h;
	void set(double l1,double b1,double h1)
	{
		l=l1;
		b=b1;
		h=h1;
	}
	double volume()
	{
		return l*b*h;
	}
}

public class boxdemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
box1 b1=new box1();
box1 b2=new box1();
b1.set(10.3,9.9,7.6);
b2.set(11.5,10.5,23.4);
double v1,v2;
v1=b1.volume();
v2=b2.volume();
System.out.println("the volume of first room"+v1);
System.out.println("the volume of second room "+v2);

	}

}
