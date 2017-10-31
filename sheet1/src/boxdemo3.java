class box3
{
	double l,b,h,v;
	box3(double l1,double b1,double h1)
	{
		l=l1;
		b=b1;
		h=h1;
		v=l*b*h;
	}
	void compare (box3 b1, box3 b2)
	{
		if(b1.v>b2.v)
		{
			System.out.println("First Room Is having Greater volume");
				}
		else	
		if(b1.v<b2.v)
		{
			System.out.println("first room   volume has less volume");
		}
		else
		{
			System.out.println("both the rooms has equal volume");
		}
		
		}
		
	}
	
public class boxdemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		box3 b1=new box3(10.4,9.9,8.9);
		box3 b2=new box3(15.4,6.9,8.9);
b1.compare(b1, b2);//object passing to fn
	}

}
