interface room11{
	double l=10.5;
	double b=11.6;
	double h=7.8;
	double v=l*b*h;
	double volume();
}
	
interface room12{
	double l=10.5;
	double b=11.6;
	double h=7.8;
	double v=l*b*h;
	double volume1();
}
	class roomtest implements room11,room12
	{
		//double v1,v2;
	public	double volume()
		{
			System.out.println("length "+room11.l);
			System.out.println("breadth "+room11.b);
			System.out.println("height "+room11.h);
			System.out.println("volume "+room11.v);
			return room11.v;
		}
	public	double volume1()
		{
		System.out.println("length "+room12.l);
		System.out.println("breadth "+room12.b);
		System.out.println("height "+room12.h);
		System.out.println("volume "+room12.v);
		return room12.v;
		}
	}

public class interfacevol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
room11 r1;
room12 r2;
r1= new roomtest();
r2= new roomtest();
double v1,v2;
v1=r1.volume();
v2=r2.volume1();
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
