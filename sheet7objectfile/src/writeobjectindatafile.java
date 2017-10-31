//write full object in data file in binary mode
//and read full object from file and show on screen
//using loop to write data taken from user into file
//using while to read from file all data and show on screen
import java.io.*;//to write an object, the class must 
//implemment the serializable interface
class ObjectData implements Serializable 
{
	String name;
	int age;
	float salary;
	transient String dep; //dont write to file
	//this var can use only for calculation work it create own loacation in class
	//but not write in file with object
	//when v read frm file if this var is printed on screenit will show null
	public void input()
	{
	//	InputStreamReader ir=new InputStreamReader(System.in);
	//	BufferedReader br=new BufferedReader(ir);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter name:");
		try{
			name=br.readLine();
			
		}catch(Exception e){
			name=null;
		}
		do{
			System.out.println("enter age:");
			try{
				age=Integer.parseInt(br.readLine());
				
			}catch(Exception e){
				age=-1;
			}
		}while(age<1);
			System.out.println("enter salary:");
			try{
				salary=Float.parseFloat(br.readLine());
				
			}catch(Exception e){
				salary=-1;
			}
			System.out.println("enter department:");
			try{
				dep=br.readLine();
				
			}catch(Exception e){
				dep=null;
			
		}
		}
		public void show(){
			System.out.println("name :"+name);
			System.out.println("age :"+age);
			System.out.println("salary :"+salary);
			System.out.println("dep. :"+dep);
			
			
		}
		
	}
	public class writeobjectindatafile{
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ObjectOutputStream obout=null;//write in data file
ObjectInputStream obin=null;//read from data file
try{
	obout=new ObjectOutputStream(new FileOutputStream("objectdata1.dat",true));
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	while(true){
		try{
			System.out.println("do u want to enter more?(y/n):");
			String result=br.readLine();
			//Strings are compared like this if(name.equals("yk")==true)
			if(result.equals("Y")==false && result.equals("y")==false){
				break;
			}
			ObjectData ob =new ObjectData();
			ob.input();
			obout.writeObject(ob);
		}catch (Exception e){
			
		}
		}
	}
catch(FileNotFoundException e){
	
}
catch(IOException e ){
	
}
finally{
	try{
		obout.close();
	}catch(IOException e){
	}
}
try{
	obin=new ObjectInputStream(new FileInputStream("objectdata1.dat"));
	while(true){
		ObjectData temp=(ObjectData)obin.readObject();//read onject from file
		temp.show();
		System.out.println("-------------------");
		
	}
}
catch(FileNotFoundException e){
	System.out.println("error:"+e.getMessage());
	
}
catch(IOException e){
	System.out.println("error:"+e.getMessage());
}
catch(ClassNotFoundException e){
	
}
finally{
	try{
		obin.close();
		
	}catch(IOException e){
}
}
	}

}
