package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器端
 * 目标：实现一个用户可以正常收发多条消息
 * @author yang
 */
public class N16_MultiChatServer {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Server----------");
		//1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		//2、阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		
		DataInputStream dis = new DataInputStream(client.getInputStream());//输入流（3、接收消息）
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());//输出流（4、返回消息）
		boolean isRunning = true;
		while(isRunning){
			//3、接收消息
			String msg = dis.readUTF();//接收数据
			//4、返回消息
			dos.writeUTF(msg);
			dos.flush();
		}
		//5、释放资源
		dos.close();
		dis.close();
		client.close();
	}
}
