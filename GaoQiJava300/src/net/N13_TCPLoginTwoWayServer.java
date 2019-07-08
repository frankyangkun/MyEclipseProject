package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录，双向（即服务器告诉客户端登录是否成功）
 * 创建服务器，步骤如下：
 * 1、指定端口，使用ServerSocket创建服务器
 * 2、阻塞式等待连接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 * @author yang
 */
public class N13_TCPLoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Server----------");
		 //1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		 //2、阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		 //3、操作：输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());//输入流
		String datas = dis.readUTF();//接收数据
		String uname = "";
		String upwd = "";
		//分析
		String[] dataArray = datas.split("&");
		for (String info : dataArray) {
			String[] userInfo = info.split("=");
			if(userInfo[0].equals("uname")){
				System.out.println("你的用户名为："+userInfo[1]);
				uname = userInfo[1];//别忘了这步
			}else if(userInfo[0].equals("upwd")){
				System.out.println("你的密码为："+userInfo[1]);
				upwd = userInfo[1];//别忘了这步
			}
		}
		//输出登录结果到客户端
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());//输出流
		if(uname.equals("shsxt") && upwd.equals("laopei")) {//后期需查数据库
			dos.writeUTF("登录成功。");
		}else{
			dos.writeUTF("用户名或密码错误");
		}
		dos.flush();
		 //4、释放资源
		dis.close();
		client.close();
//		server.close();//一般不会关闭服务，除非维护
	}
}
