package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在线聊天室：服务器端
 * 目标：加入容器，实现群聊
 * @author yang
 */
public class N19_MultiUserChatServer {
//	private List<Channel> all = new ArrayList<>();//在多线程中，我们使用容器时，如果既要改，又要遍历，不建议使用ArrayList，使用JUC里的
	//多线程环境下，线程1可能在遍历容器，但线程2可能退出了，此时就可能出现并发问题，因此推荐使用juc包里的CopyOnWriteArrayList
	//CopyOnWriteArrayList就没问题，因为你在用的时候会复制一份，别人改的时候会同步，你始终操作的是副本
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
	public static void main(String[] args) throws IOException {
		System.out.println("---------Server----------");
		//1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		//2、阻塞式等待连接accept
		while(true){
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			Channel c = new Channel(client);
			all.add(c);//管理所有的成员
//			new Thread(new Channel(client)).start();//因为是实现的Runnable，所以需要Thread
			new Thread(c).start();
		}
	}
	//一个用户代表一个Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;//发消息的人名称
		
		public Channel(Socket client) {//注意写法，括号里不需要写dis和dos，因为它们都是从client带来的
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());	
				isRunning = true;//如果没出错，就为真
				this.name = receive();//线程启动前，先获取发消息人的名称
				this.send("欢迎你的到来");//发给自己欢迎信息
				sendOthers(this.name+"来到了聊天室",true);//发给别人系统提示，true表示系统消息
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
				System.out.println("---服务端发送----");
				release();
			}
		}
		//群聊：获取自己的消息，发给其他人
		private void sendOthers(String msg,boolean isSys){
			for (Channel other : all) {
				if(other==this)//如果other是自己，跳出循环，不发给你自己
				{
					continue;
				}
				if(!isSys){//如果不是系统消息，直接显示消息本来内容
					other.send(this.name+"对所有人说："+msg);//群聊消息				
				}else{
					other.send(msg);//系统消息
				}
			}
		}
		//释放资源
		private void release(){
			this.isRunning = false;
			N18_Utils.close(dos,dis,client);
			all.remove(this);//离开群聊
			sendOthers(this.name+"离开了聊天室。",true);
		}
		@Override
		public void run() {
			while(isRunning){
				String msg = receive();
				if(!msg.equals("")){
//					send(msg);//接收消息如果不为空，就发送
					sendOthers(msg,false);//不再发给自己，发给其他人
				}
			}
		}
	}
}