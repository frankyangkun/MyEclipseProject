package net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 使用多线程封装发送端
 * 1、发送消息
 * 2、从控制台获取信息
 * 3、释放资源
 * 4、重写run
 * @author yang
 */
public class N18_ClientSend implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;//发消息人的名称
	
	public N18_ClientSend(Socket client,String name){
		this.client = client;
		console = new BufferedReader(new InputStreamReader(System.in));//用户输入
		this.isRunning = true;
		this.name = name;
		try {
			dos = new DataOutputStream(client.getOutputStream());//输出流（2、客户端发送消息）
			send(name);//管道建立好后先发名称过去
		} catch (IOException e) {
			System.out.println("===客户端发送构建===");
			this.release();
		}
	}
	@Override
	public void run() {
		while(isRunning){
			String msg = getStrFromConsole();
			if(!msg.equals("")){
				send(msg);
			}
		}
	}
	//发送消息
	private void send(String msg){
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("===客户端发送===");
			release();
		}
	}
	//从控制台获取信息
	private String getStrFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	//释放资源
	private void release(){
		this.isRunning = false;
		N18_Utils.close(dos,client);
	}
}
