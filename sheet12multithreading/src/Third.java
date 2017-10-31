//it is a third programe
//multi threading using Runnable interface
//using threads we can run more than  one methods at the same time
//but they are processor dependent


 class Test2 implements Runnable {
	 //here thread is the class
	 //runnable is supporting threads
	 Thread t;//create object of thread class
	 //because actually thread is doing work
	 
public Test2(){
	t=new Thread(this);
	t.setDaemon(true); //make it child thread
	t.setPriority(Thread.MIN_PRIORITY);
	t.start();
	
}
public void run(){
	for(int i=1;i<=10;i++){
		try{
			Thread.sleep(100); //100miliseconds wait
			
		}catch(InterruptedException e){
			
		}
		System.out.println("Run:"+i);
		
	}
}
 }
 class Third{
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t=new Test2(); //create object of the class
		
		for(int i=1;i<=20;i++){
			try{
				Thread.sleep(200); //200 milisecs wait
				
			}catch(InterruptedException e){
				
			}
			System.out.println("Main:"+i);
		}
		}
		
	}
	

