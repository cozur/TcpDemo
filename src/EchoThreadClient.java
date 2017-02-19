import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThreadClient{

	public static void  main(String[] args){
		// TODO Auto-generated method stub
		try
		{
			//创建和服务器的连接
			Socket client = new Socket("localhost",9999);
			BufferedReader buff = null;
			BufferedReader input = null;
			PrintStream output = null;

			buff =new BufferedReader(new InputStreamReader(client.getInputStream()));
			input = new BufferedReader(new InputStreamReader(System.in));
			output = new PrintStream(client.getOutputStream());
			boolean flag = true;
			while(flag)
			{
				System.out.println("请输入信息：");
				String msg = input.readLine();
				if(msg==null||msg.equalsIgnoreCase("bye"))
				{
					flag = false;
				}
				else
				{
					output.println(msg);//输出给服务器
					String echo = buff.readLine();
					System.out.println(echo);
				}
			}
//			System.out.print(client.toString());
			buff.close();
			client.close();
			input.close();
			output.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
