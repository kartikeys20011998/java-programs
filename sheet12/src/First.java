
 class Test extends Thread {

	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			try
			{
				Thread.sleep(200);//200 milliseconds wait
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("Run: "+i);
		}
	}
 }

class First
{
	
	public static void main (String ar[]) {
		Test t =new  Test();//create object of class test 
	//	t.setPriority(Thread.NORM_PRIORITY);
		// 1 TO 10 HERE WE ARE SETTING PRIORITY OF THE THREAD 
		t.setPriority(10);
		// we can replace above statement with this 
	//	t.setPriority(Thread.MAX_PRIORITY);
	//	t.setPriority(10);
		// 1 TO 10 WE CAN REPLACE ABOVE STATEMENT WITH THIS 
		//we are requisiting processor to do our work on maximum priority basis
	//	t.setPriority(Thread.MIN_PRIORITY);
	//	t.setPriority(1);
		// 1 TO 10 WE CAN REPLACE ABOVE STATEMENT WITH THIS 
		//we are requisiting processor to do our work on mINIMUM priority basis
	t.setDaemon(true);
		//true make it a child thread 
	//	t.setDaemon(false);
		//if true  now t is child of main 
		//false ... make it an independent thread 
		//if false then it is a processor dependent 
		t.start();
		//create memory for thread ,call run()
		for(int i=0;i<=10;i++)
		{
			try
			{
				Thread.sleep(200);//100 milliseconds wait 
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("Main : "+i);
		}

	}
}

