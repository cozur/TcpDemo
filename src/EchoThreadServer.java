import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoThreadServer{
//	private Socket server;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//����������
			ServerSocket server = new ServerSocket(9999);		
			//�ͻ��˶���
			Socket client = null;
			boolean flag = true;
			EchoThread echo = null;
			System.out.println("�������Ѿ��������ȴ��ͻ�������");
			while(flag)
			{		  
			   client = server.accept();//����һ����������
			   //����һ����Ӧ�̣߳�һ���ͻ��˶�Ӧһ���߳�		
//			   new Thread(new EchoThread(client)).start();	
			   echo = new EchoThread(client);
			   new Thread(echo).start();
			   
			}
			server.close();		
			client.close();
			System.out.println("�������Ѿ��رգ�");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
