//using join ans isAlive
class Test4 extends Thread  {
	public Test4()
	{
	setDaemon(false);
	setPriority(Thread.MIN_PRIORITY);
	start();
}
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			try
			{
				Thread .sleep(100);
				
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("Thread still running : "+this.isAlive());
			System.out.println("Run : "+i);
	}
	}
}

public class Fourth {

	
	public static void main(String[] args) {
		Test4 t=new Test4();
		try
		{
			t.join();
			//let me finish first
			//by joining above statement main will wait for finish the thread aftr finishing 
			//the thread's work then main's work will start 
		}
		catch(Exception e)
		{
			
		}
		System.out.println("Thread still running : "+t.isAlive());
		for(int i=1;i<=10;i++)
		{
			try
			{
				Thread.sleep(200);
				
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("Main: "+i);
		}
		

	}

}
