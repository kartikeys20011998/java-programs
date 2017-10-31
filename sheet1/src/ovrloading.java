class overloading{
	//method over loading
	//when more then one method havonh sdame name it is called method overloading
	//it is possiablw when arguments are different in nos. or in types
	double l,b;
	int r;
	double area(double l1)
	{	l=l1;
	return l*l;
	}
double area(double l1,double b1)
{l=l1;
b=b1;
return l*b;
}
double area(int r1)
{r=r1;
return 3.14*r*r;
}
}




public class ovrloading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
double a;
overloading fig=new overloading();
a=fig.area(2.5);
System.out.println("area is "+a);
a=fig.area(2,8);
System.out.println("area is "+a);
a=fig.area(2);
System.out.println("area is"+a);

	
}
	}


