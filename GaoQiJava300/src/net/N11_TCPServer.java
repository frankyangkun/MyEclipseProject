package net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建服务器，步骤如下：
 * 1、指定端口，使用ServerSocket创建服务器
 * 2、阻塞式等待连接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 * @author yang
 */
public class N11_TCPServer {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Server----------");
		 //1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		 //2、阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		 //3、操作：输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());//输入流
		String data = dis.readUTF();//接收数据
		System.out.println(data);
		 //4、释放资源
		dis.close();
		client.close();
//		server.close();//一般不会关闭服务，除非维护
	}
}
