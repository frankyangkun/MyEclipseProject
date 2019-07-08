package net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 模拟登录，双向（即服务器告诉客户端登录是否成功） 多客户端请求
 * 创建客户端，步骤如下：
 * 1、建立连接，使用Socket创建客户端+服务端的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 * @author yang
 */
public class N15_TCPLoginMultiClient {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Client----------");
//		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));//用户输入,封装成init方法，并且被构造器调用
//		System.out.println("请输入用户名：");
//		String uname = console.readLine();
//		System.out.println("请输入密码：");
//		String upwd = console.readLine();
		
		 //1、建立连接，使用Socket创建客户端+服务端的地址和端口
		Socket client = new Socket("127.0.0.1",8888);
		 //2、操作：输入输出流操作 先请求后响应 建议使用DataOutputStream
//		DataOutputStream dos = new DataOutputStream(client.getOutputStream());//输出流，封装为Send类
//		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);//封装为Send类中的send方法
//		dos.flush();
//		new Send(client).send("uname="+uname+"&"+"upwd="+upwd);//使用封装好的Send类，括号里的需要调整一下，在init中返回
		new Send(client).send();//使用封装好的Send类
		
		//接收服务器端返回的结果
//		DataInputStream dis = new DataInputStream(client.getInputStream());//输入流，封装为Receive类
//		String result = dis.readUTF();//接收数据
//		System.out.println(result);
		new Receive(client).receive();//使用封装好的Receive类
		
		 //3、释放资源
//		dos.close();//先不考虑释放
		client.close();
	}
	static class Send{//发送类
		private Socket client;
		private DataOutputStream dos;
		private BufferedReader console;
		private String msg;
		public Send(Socket client){
//			this.msg = init();//调用初始化方法，要放到console后面，否则空指针
			console = new BufferedReader(new InputStreamReader(System.in));
			this.msg = init();//调用初始化方法
			this.client = client;
			try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}//输出流
		}
		public void send(){//发送
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private String init(){//改成String返回类型，返回"uname="+uname+"&"+"upwd="+upwd
//			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));//用户输入，丢到构造器
			System.out.println("请输入用户名：");
			try {
				String uname = console.readLine();
				System.out.println("请输入密码：");
				String upwd = console.readLine();
				return "uname="+uname+"&"+"upwd="+upwd;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";//如果有异常，返回空字符串
		}
	}
	static class Receive{//接收类
		private Socket client;
		private DataInputStream dis;
		public Receive(Socket client){
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}//输入流
		}
		public void receive(){//接收
			String result;
			try {
				result = dis.readUTF();//接收数据
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}