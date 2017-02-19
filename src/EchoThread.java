import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

//·þÎñÆ÷¶Ë
public class EchoThread implements Runnable{
	private Socket client;
	
	EchoThread(Socket client)
	{
		this.client = client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			BufferedReader buff = new BufferedReader(new InputStreamReader(client.getInputStream()));
		    PrintStream out = new PrintStream(client.getOutputStream());
		    boolean flag = true;
		    while(flag)
		    {
		    	String msg = buff.readLine();
		    	if(msg==null||msg.equalsIgnoreCase("bye"))
		    	{
		    		flag = false;
		    	}
		    	out.println("Echo:"+msg);
		    }
		    buff.close();
		    client.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
