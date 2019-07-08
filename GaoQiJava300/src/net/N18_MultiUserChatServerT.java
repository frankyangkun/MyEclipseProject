package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器端
 * 目标：封装使用多线程实现多个用户可以正常收发多条消息，解决前面的排队问题
 * 解决问题：
 * 1、代码不好维护
 * 2、客户端读写分开
 * @author yang
 */
public class N18_MultiUserChatServerT {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Server----------");
		//1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		//2、阻塞式等待连接accept
		while(true){
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();//因为是实现的Runnable，所以需要Thread
		}
	}
	//一个用户代表一个Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		
		public Channel(Socket client) {//注意写法，括号里不需要写dis和dos，因为它们都是从client带来的
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());	
				isRunning = true;//如果没出错，就为真
			} catch (IOException e) {
				System.out.println("---服务端构建----");
				release();
			}
		}
		//接收消息
		private String receive(){
			String msg = "";//加空值避免空指针
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				System.out.println("---服务端接收----");
				release();
			}
			return msg;
		}
		//发送消息
		private void send(String msg){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
//				e.printStackTrace();
//				System.out.println(e);
				System.out.println("---服务端发送----");
				release();
			}
		}
		//释放资源
		private void release(){
			this.isRunning = false;
			N18_Utils.close(dos,dis,client);
		}
		@Override
		public void run() {
			while(isRunning){
				String msg = receive();
				if(!msg.equals("")){
					send(msg);//接收消息如果不为空，就发送
				}
			}
		}
	}
}