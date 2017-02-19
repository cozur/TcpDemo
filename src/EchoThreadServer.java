import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoThreadServer{
//	private Socket server;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//服务器对象
			ServerSocket server = new ServerSocket(9999);		
			//客户端对象
			Socket client = null;
			boolean flag = true;
			EchoThread echo = null;
			System.out.println("服务器已经启动，等待客户端请求！");
			while(flag)
			{		  
			   client = server.accept();//这是一个阻塞方法
			   //生成一个响应线程，一个客户端对应一个线程		
//			   new Thread(new EchoThread(client)).start();	
			   echo = new EchoThread(client);
			   new Thread(echo).start();
			   
			}
			server.close();		
			client.close();
			System.out.println("服务器已经关闭！");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
