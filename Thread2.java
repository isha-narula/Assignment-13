class Thread1 extends Thread
{
	int i;
	public synchronized void run()
	{
		for(i=0;i<500;i++)
		{
			System.out.println(i);
		}
		try 
		{
			Thread.sleep(100);
		}
		catch(Exception e) 
		{
			System.out.println("Some error occured");
		}
	}
}
class Thread2 implements Runnable
{
	int i;
	public synchronized void run() 
	{
		for(i=500;i<1000;i++)
		{
			System.out.println(i);
		}
		try 
		{
			Thread.sleep(100);	
		}
		catch(Exception e)
		{
			System.out.println("Error occured");
		}
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Thread1 t = new Thread1();
		Thread t1 = new Thread(t);
		t1.start();
		Thread2 th2 = new Thread2();
		Thread t2 = new Thread(th2);
		t1.join();
		t2.start();
		t2.join();

	}
	
}