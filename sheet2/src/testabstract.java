abstract class abc{
	abstract double volume();
}
class room1 extends abc
{
	double l,b,h,v;
	room1(double l1,double b1,double h1)
	{
		l=l1;
		b=b1;
		h=h1;
		v=l*b*h;
		
	}
		double volume(){
		System.out.println("the volume of room1"+v);
		return v;
	
}
}
class room2 extends abc{
	double l,b,h,v;
	
		room2(double l2,double b2,double h2)
		{
			l=l2;
			b=b2;
			h=h2;
			v=l*b*h;
		}
			double volume(){
		
		System.out.println("the volume of room2"+v);
		return v;
	}
			
	}
	
public class testabstract {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
abc r;
double v1,v2;
r=new room1(12.3,9.7,4.4);
v1=r.volume();
r=new room2(13.2,12.3,23.3);
v2=r.volume();

	if(v1>v2)
	{
		System.out.println("First Room Is having Greater volume");
			}
	else	
	if(v1<v2)
	{
		System.out.println("first room   volume has less volume");
	}
	else
	{
		System.out.println("both the rooms has equal volume");
	}
	

	}

}
