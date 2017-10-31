//abstract class and method //to bound each class together
abstract class Maruti1{ // a class having atleast one abstract method
	//must be declared abstract
	//abstract method does not have body
	//they are used to force subclasses override it
	abstract void show(); //virtual void show()=0; in c++
	
	void display(){
		System.out.println("non-abstract method");
		
	}
	
	
}
class Alto1 extends Maruti1{
	void show(){ //here shoe is compulsory in abstract method
		// override Maruti show
	display();
	System.out.println("Alto1");
	
}
}
class Zen1 extends Maruti1{
	void show(){ //override maruti show
	System.out.println("Zen1");
	}
}
	
	
	

public class RunTAbs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Maruti1 m; // it is a reference variable
//Maruti m=new Maruti();//this is wrong 
// no object is formed in abstrct class method
m=new Alto1(); // assign it to alto object
m.show();// call alto overridden method
m=new Zen1();
m.display();
m.show(); // here call of non abstract method of abstrct class

	}

}
// we cannot make abstrct class object directly.
//we make ref of abstract class and assign it to sub class objects for run time 
//polymorphism
//every sub class must have show method compulsary 