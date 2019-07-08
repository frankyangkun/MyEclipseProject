package net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建客户端，步骤如下：
 * 1、建立连接，使用Socket创建客户端+服务端的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 * @author yang
 */
public class N11_TCPClient {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Client----------");
		 //1、建立连接，使用Socket创建客户端+服务端的地址和端口
		Socket client = new Socket("127.0.0.1",8888);
		 //2、操作：输入输出流操作 建议使用DataOutputStream
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());//输出流
		String data = "hello";
		dos.writeUTF(data);
		dos.flush();
		 //3、释放资源
		dos.close();
		client.close();
	}
}
