//multi threading using thread class
//using thread we can run more than one methods at the same time
//but they are processesor dependent

 class Test extends Thread { //inherits thread class
	 
public void run(){
	for (int i=1;i<=10;i++){
		try{
			Thread.sleep(200);
			
		}catch(InterruptedException e){
			
		}
		System.out.println("Run:"+i);
	}
	}
}
	class First{
		
	
	public static void main(String[] args) {
		Test t=new Test();//create object of Testclass
		t.setPriority(Thread.NORM_PRIORITY); //5   1to 10
		//here we r setting priority of the thread
		//t.setPriority(5); we can replace above statement wd ths
		t.setPriority(Thread.MAX_PRIORITY);// 5 1 to 10
		
		
		
		//t.setPriority(10);
		//we r requesting processesor to do pur work on maximum priority basis
		t.setPriority(Thread.MIN_PRIORITY);
		t.setPriority(1);//we can replave above statemnt wd ths
		//we r requesting processesor to do pur work on min priority basis
		//t.setDaemon(true) //true or fasle true to make it a child thread
		t.setDaemon(false);
		//if true now t is child of main
		//false to make it independeny thread
		//if false then it is a processor dependent
		t.start(); //create memory for thread,call run();
		for(int i=1;i<=10;i++){
			try{
				Thread.sleep(100); //100 milisecs wait
				
			}catch(InterruptedException e){
				
			}
			System.out.println("Main:"+i);
		}
		}
		
	}


