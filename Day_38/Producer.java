
public class Producer implements Runnable
{
    private CubbyHole cubbyhole;
    private int number;
    public Producer(CubbyHole c, int number) 
    {
        cubbyhole = c;
        this.number = number;
    }
    public void run() 
     {
        for (int i = 1; i <= 10; i++) 
			{
            cubbyhole.put(i);
            try 
			  {
	                Thread.sleep(1000);
            } 
		catch (InterruptedException e) { }
         }
    }
}