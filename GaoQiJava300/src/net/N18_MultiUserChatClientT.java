package net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室：客户端
 * 目标：封装使用多线程实现多个用户可以正常收发多条消息，解决前面的排队问题
 * @author yang
 */
public class N18_MultiUserChatClientT {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---------Client----------");
		 //1、建立连接，使用Socket创建客户端+服务端的地址和端口
		Socket client = new Socket("127.0.0.1",8888);
		//2、客户端发送消息
		new Thread(new N18_ClientSend(client)).start();
		new Thread(new N18_ClientReceive(client)).start();
	}
}
