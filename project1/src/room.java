
public class room {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double l=10,b=5,h=3,v,a,s;
		v=l*b*h;
		a=2*(l*b+b*h+h*l);
		s=Math.sqrt(l*l+b*b+h*h);
		System.out.println("the volume of the room is "+v);
		System.out.println("the area of the room is " +a);
		System.out.println("the sum of diagonals of a room is " +s);
		
		

	}

}
