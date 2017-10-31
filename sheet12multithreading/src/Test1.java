//it is a second programe
//multi threading using thread class
//using threads we can run more than  one methods at the same time
//but they are processor dependent
//thread is a class so it is extends due to polymorphism

 class Test1 extends Thread {
	 //here thread is the class
public Test1(){
	setDaemon(true); //make it child thread
	setPriority(Thread.MIN_PRIORITY);
	start();
	
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
 class second{
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 t=new Test1();
		t.start(); //create memory for thread,call run();
		for(int i=1;i<=20;i++){
			try{
				Thread.sleep(200); //200 milisecs wait
				
			}catch(InterruptedException e){
				
			}
			System.out.println("Main:"+i);
		}
		}
		
	}
	


