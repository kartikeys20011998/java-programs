//using join and is Alive
class Test4 extends Thread{
	

	
		 //here thread is the class
	public Test4(){
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
	 class Fourth{
		 
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Test4 t=new Test4();
			t.join(); //let me finish frst
			//by joining above statement main will finish the thread
			for(int i=1;i<=20;i++){
				try{
					Thread.sleep(200); //200 milisecs wait
					
				}catch(InterruptedException e){
					
				}
				System.out.println("Main:"+i);
			}
			}
			
		}
		





