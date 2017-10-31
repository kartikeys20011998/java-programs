
public class numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
double a=3,b=7,c=9,d=0;
if(a>b&&a>c)
{
d=Math.pow(a, 3.0);	
	System.out.println("the cube of greater number is " +d);
}
else
	if(b>a&&b>c)
	{
		d=Math.pow(b, 3.0);	
		System.out.println("the cube of greater number is " +d);
	}		
	
	else
	{
			d=Math.pow(c, 3.0);	
			System.out.println("the cube of greater number is " +d);
		}		
	
	}

}
