class box{
	private double width;
	private double height;
	private double depth;
	  box(double w,double h,double d ){
		  width=w;
		  height=h;
		  depth=d;
		  
	  }
	  double volume(){
		  return width*height*depth;
		  
	  }
}
class  boxweight extends box{
	double weight;
	boxweight(double w,double h,double d,double m)
	{
		super(w,d,h);//without using super cant assign values to superclass variable
		//inside the subclass constructer
		//super is the keyword which is used to inherit
		weight=m;
		
	}
}
	  class shipment extends boxweight{
		  double cost;
		  shipment(double w,double h,double d,double m,double c){
			  super(w,d,h,m);
			  cost=c;
			  
		  }
	  }

public class inheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
shipment s1=new shipment(10,2,3,4,6);
double vol;
vol=s1.volume();
System.out.println("voulume="+vol);
System.out.println("weight="+s1.weight);
System.out.println("cost="+s1.cost);


	}

}
