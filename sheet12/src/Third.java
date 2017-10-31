//it is third programme
//multi threading using runnable interface
//using thread we can run more than one methods  at the same time 
//but they are processor dependent 
// runnable is a interface so it implements
class Test2 implements Runnable //runnable is supporting threads 
{
	Thread t;
	//create object of thread class bcz actually thread is doing work
	public Test2()
	{
		t=new Thread (this);
		t.setDaemon(true);
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
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
			System.out.println("Run : "+i);
	}
}
}

public class Third {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t=new Test2();
		//createw object of test  class 
		for(int i=1;i<=10;i++)
		{
			try
			{
				Thread .sleep(200);
				
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("Main : "+i);
		
	}

}
}

