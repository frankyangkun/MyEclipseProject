package net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室：客户端
 * 目标：实现多个用户可以正常收发多条消息
 * @author yang
 *
 */
public class N16_MultiUserChatClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---------Client----------");
		 //1、建立连接，使用Socket创建客户端+服务端的地址和端口
		Socket client = new Socket("127.0.0.1",8888);
		//2、客户端发送消息
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));//用户输入
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());//输出流（2、客户端发送消息）
		DataInputStream dis = new DataInputStream(client.getInputStream());//输入流（3、获取消息）
		boolean isRunning = true;
		while(isRunning){
			String msg=console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			//3、获取消息
			msg = dis.readUTF();//接收数据
			System.out.println(msg);
		}
		//4、释放资源
		dos.close();
		dis.close();
		client.close();
	}
}
