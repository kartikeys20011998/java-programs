//22/06/2016
class Maruti{
	void show(){ //virtual void show () in c++
		System.out.println("Maruti");
	}
}
//java methods are by default virtual
class Alto extends Maruti{
	void show(){
		System.out.println("Alto");
		
		
	}
}
class Zen extends Maruti{
	void show(){
		System.out.println("Zen");
		
	
}
}
public class RunT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//dynamic methos dispatch(runtime polymorphism)
		Maruti m; //create only reference not object 
		// this is only the variable of frst class
		m=new Alto();//assign it to alto object
        m.show();// call alto overridden method
		m=new Zen();
		m.show();
		// m is controlling both class object
		//in this polymorphism we create referrence base class 
	//and assign it to sub class
	}



}