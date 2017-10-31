//interface at run time of many class
//one class or more the one class may interface
//then u have to use all methods in evry interface
class japan{
	void showjapan(){
		System.out.println("japan");
		
	}
	
}
interface Maruti3{
	int a=110;
	String str="kriti sharma";
	double b=999.9;
	//we can not change the value of a in this program
	//at any where we can use this var. anywhere in program
	//we cannot write any method body in interferance class
	void showw();
	//method are by default public and abstract
	//variables are by default static n final(constant)
	void showw1();
}
//any number of interfaces can be implemented by a class
interface Maruti2{
	int a=10;
	String str="kriti"; // these variable are static of this interface
	double b=9.9;
	//we can not change the value of a in this program
		//at any where we can use this var. anywhere in program
		//we cannot write any method body in interferance class
		void show();
		//method are by default public and abstract
		//variables are by default static n final(constant)
		void show1();
	
}
//note:an abstract class may not override any of the interface methods
class Alto2 extends japan implements Maruti2,Maruti3{
	//class alto2 extends japan(inheritance) implements Maruti2 n Maruti3 also
	public void showw(){
		System.out.println(Maruti3.a);
		System.out.println(Maruti3.b);
	}
	public void showw1(){
		System.out.println(Maruti3.str);
		
		
	}
	public void show(){
		showjapan();
		System.out.println("Alto");
		
		
	}
	public void show1(){
		System.out.println("Alto"+Maruti2.a);
		
		
	}
	
}
public class runtinterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Maruti2 m;//make reference of Maruti2
Maruti3 m1;//make reference of Maruti3
m=new Alto2();
m.show();
m.show1();
//below we have to use Maruti3 object to call its fns/methods
m1=new Alto2();
m1.showw();
m1.showw1();




	}

}
