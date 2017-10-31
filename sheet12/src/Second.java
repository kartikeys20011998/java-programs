
//it is second programme
//multi threading using thread class 
//using Thread we can run more then one methods at the same time
//but they are processor dependent
//thread is a class so  it extends using polymorphism
class Test1 extends Thread  {
	public Test1()
	{
	setDaemon(true);
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
		System.out.println("Run : "+i);
	}
}
}
 class second
 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Test1 t=new Test1();//create object of test class 
	 for(int i=1;i<=20;i++)
	 {
				try
				{
					Thread.sleep(100);//100 milliseconds wait 
				}
				catch(InterruptedException e)
				{
					
				}
				System.out.println("Main : "+i);
		 }
	}

}
