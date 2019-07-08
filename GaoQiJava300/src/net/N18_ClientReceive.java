package net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装接收端
 * 1、接收消息
 * 2、释放资源
 * 3、重写run
 * @author yang
 */
public class N18_ClientReceive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	public N18_ClientReceive(Socket client){
		this.client = client;
		this.isRunning = true;
		try {
			dis = new DataInputStream(client.getInputStream());//输入流（3、获取消息）
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("====客户端接收构建====");
			release();
		}
	}
	//接收消息
	private String receive(){
		String msg = "";//加空值避免空指针
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("====客户端接收====");
			release();
		}
		return msg;
	}
	@Override
	public void run() {
		while(isRunning){
			String msg = receive();
			if(!msg.equals("")){
				System.out.println(msg);
			}
		}
	}
	//释放资源
	private void release(){
		this.isRunning = false;
		N18_Utils.close(dis,client);
	}
}
