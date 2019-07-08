package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器端
 * 目标：使用多线程实现多个用户可以正常收发多条消息，解决前面的排队问题
 * 问题：
 * 1、代码不好维护
 * 2、客户端读写没分开，必须先写后读
 * @author yang
 */
public class N17_MultiUserChatServerT {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Server----------");
		//1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		//2、阻塞式等待连接accept
		while(true){
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			
			new Thread(()->{//使用lambda简化写法，不用单独写个类，里面就是run方法的实现，缺点是代码太多，不好维护，最好还是分开写
				DataInputStream dis=null;//必须初始化，否则while里dis有错
				DataOutputStream dos=null;//必须初始化，否则下面try里dos有错
				try {
					dis = new DataInputStream(client.getInputStream());//输入流（3、接收消息）
					dos = new DataOutputStream(client.getOutputStream());//输出流（4、返回消息）					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				boolean isRunning = true;
				while(isRunning){
					//3、接收消息
					String msg;
					try {
						msg = dis.readUTF();
						//4、返回消息
						dos.writeUTF(msg);
						dos.flush();
					} catch (IOException e) {
//						e.printStackTrace();
						isRunning = false;//一旦停止某客户端，就会报异常，因为一直在读消息，但已读不到了，所以要加入这句
					}
				}
				//5、释放资源
				try {
					if(dos!=null){
						dos.close();
					}
					if(dis!=null){
						dis.close();
					}
					if(client!=null){
						client.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}